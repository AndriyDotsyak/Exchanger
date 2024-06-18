import extension.implementation
import extension.ksp
import org.gradle.kotlin.dsl.DependencyHandlerScope

object Database {

    object Versions {
        const val ROOM = "2.6.1"
    }

    internal const val ROOM = "androidx.room:room-ktx:${Versions.ROOM}"
    internal const val ROOM_RUNTIME = "androidx.room:room-runtime:${Versions.ROOM}"
    internal const val ROOM_COMPILER = "androidx.room:room-compiler:${Versions.ROOM}"

}

fun DependencyHandlerScope.implementationDatabase() {
    implementation(Database.ROOM)
    implementation(Database.ROOM_RUNTIME)
    ksp(Database.ROOM_COMPILER)
}
