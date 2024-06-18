import extension.implementation
import org.gradle.kotlin.dsl.DependencyHandlerScope

object Datastore {

    private object Versions {
        const val DATASTORE = "1.0.0"
    }

    internal const val DATASTORE = "androidx.datastore:datastore-preferences:${Versions.DATASTORE}"
}

fun DependencyHandlerScope.implementationDatastore() {
    implementation(Datastore.DATASTORE)
}
