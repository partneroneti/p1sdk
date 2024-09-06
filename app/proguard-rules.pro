-keep class kotlin.coroutines.**
-keep class kotlinx.coroutines.**

-keep class com.facetec.sdk.** { *; }
-keep class com.acesso.acessobio_android.** { *; }
-keep class io.unico.** { *; }

-keep class br.com.makrosystems.haven.** { *; }
-keep class HavenSDK.**{ *; }
-keep class HavenSDK** { *; }
-keep class com.projeto.**{*;}

-dontwarn java.beans.ConstructorProperties
-dontwarn java.beans.Transient
-dontwarn kotlin.jvm.internal.SourceDebugExtension
-dontwarn kotlinx.parcelize.Parcelize
-dontwarn org.slf4j.impl.StaticLoggerBinder
-dontwarn proguard.annotation.Keep
-dontwarn proguard.annotation.KeepClassMembers
-dontwarn proguard.annotation.KeepName
-dontwarn proguard.annotation.KeepPublicClassMembers
