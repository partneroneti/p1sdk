
# Configuração do Partner One SDK no Projeto Android

Este repositório contém instruções para configurar o **Partner One SDK** em um projeto Android. Siga os passos abaixo para integrar corretamente o SDK.

---

## Configuração do `build.gradle`

No arquivo **`build.gradle`** do módulo do app, adicione a seguinte dependência:

```gradle
implementation('com.github.partneroneti:p1sdk:2.0') {
    exclude group: 'io.unico.security', module: 'dexguard-runtime'
}
```

> **Nota:** O módulo `dexguard-runtime` do grupo `io.unico.security` é excluído para evitar conflitos com o DexGuard.

---

## Regras do ProGuard/DexGuard

Se o projeto utiliza **ProGuard** ou **DexGuard**, é necessário adicionar as regras abaixo no arquivo **`proguard-rules.pro`** para evitar problemas durante a minificação e obfuscação do código.

### Regras específicas do Partner One e Haven SDK
```pro
# Partner One SDK
-keep class br.com.makrosystems.haven.** { *; }
-keep class HavenSDK.** { *; }
-keep class HavenSDK** { *; }

# Classes específicas do projeto
-keep class com.projeto.* { ; }
-keep class com.projeto.photoface.** { *; }
-keep class com.projeto.photoface.entity.body.** { *; }
-keep class * extends com.projeto.photoface.entity.body.Document
-keepclassmembers class ** {
    @com.projeto.photoface.entity.body.Document public *;
}
```

### Regras específicas do FaceTec SDK
```pro
# FaceTec SDK
-keep class com.facetec.sdk.** { *; }
-keepclassmembers class com.facetec.sdk.** {
    <fields>;
}
```

### Regras gerais de preservação
```pro
# Manter classes que implementam Serializable
-keep class * implements java.io.Serializable

# Preservar membros de classe com a anotação @SerializedName
-keepclassmembers class * {
    @com.google.gson.annotations.SerializedName <fields>;
}

# Ignorar avisos comuns
-dontwarn java.beans.ConstructorProperties
-dontwarn java.beans.Transient
-dontwarn kotlin.jvm.internal.SourceDebugExtension
-dontwarn kotlinx.parcelize.Parcelize
-dontwarn org.slf4j.impl.StaticLoggerBinder
-dontwarn proguard.annotation.Keep
-dontwarn proguard.annotation.KeepClassMembers
-dontwarn proguard.annotation.KeepName
-dontwarn proguard.annotation.KeepPublicClassMembers
```

---

## Passos para Configuração

1. **Adicione a dependência no `build.gradle`**  
   Certifique-se de sincronizar o projeto após incluir a dependência no `build.gradle`.

2. **Inclua as regras do ProGuard/DexGuard**  
   Copie as regras acima para o arquivo `proguard-rules.pro` localizado na pasta do módulo `app`.

3. **Teste em Modo Release**  
   Gere um APK ou AAB em modo release para garantir que o código foi preservado corretamente e não há falhas na execução.

---

## Suporte

Caso encontre problemas ou tenha dúvidas, consulte a [documentação oficial do Partner One SDK](https://github.com/partneroneti/p1sdk) ou abra uma **issue** neste repositório.

---
