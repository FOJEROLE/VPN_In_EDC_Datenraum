package org.gradle.accessors.dm;

import org.gradle.api.NonNullApi;
import org.gradle.api.artifacts.MinimalExternalModuleDependency;
import org.gradle.plugin.use.PluginDependency;
import org.gradle.api.artifacts.ExternalModuleDependencyBundle;
import org.gradle.api.artifacts.MutableVersionConstraint;
import org.gradle.api.provider.Provider;
import org.gradle.api.model.ObjectFactory;
import org.gradle.api.provider.ProviderFactory;
import org.gradle.api.internal.catalog.AbstractExternalDependencyFactory;
import org.gradle.api.internal.catalog.DefaultVersionCatalog;
import java.util.Map;
import javax.inject.Inject;

/**
 * A catalog of dependencies accessible via the `libs` extension.
*/
@NonNullApi
public class LibrariesForLibs extends AbstractExternalDependencyFactory {

    private final AbstractExternalDependencyFactory owner = this;
    private final ApacheLibraryAccessors laccForApacheLibraryAccessors = new ApacheLibraryAccessors(owner);
    private final AtomikosLibraryAccessors laccForAtomikosLibraryAccessors = new AtomikosLibraryAccessors(owner);
    private final AwsLibraryAccessors laccForAwsLibraryAccessors = new AwsLibraryAccessors(owner);
    private final AzureLibraryAccessors laccForAzureLibraryAccessors = new AzureLibraryAccessors(owner);
    private final BouncyCastleLibraryAccessors laccForBouncyCastleLibraryAccessors = new BouncyCastleLibraryAccessors(owner);
    private final FailsafeLibraryAccessors laccForFailsafeLibraryAccessors = new FailsafeLibraryAccessors(owner);
    private final FraunhoferLibraryAccessors laccForFraunhoferLibraryAccessors = new FraunhoferLibraryAccessors(owner);
    private final GooglecloudLibraryAccessors laccForGooglecloudLibraryAccessors = new GooglecloudLibraryAccessors(owner);
    private final JacksonLibraryAccessors laccForJacksonLibraryAccessors = new JacksonLibraryAccessors(owner);
    private final JakartaLibraryAccessors laccForJakartaLibraryAccessors = new JakartaLibraryAccessors(owner);
    private final JerseyLibraryAccessors laccForJerseyLibraryAccessors = new JerseyLibraryAccessors(owner);
    private final JettyLibraryAccessors laccForJettyLibraryAccessors = new JettyLibraryAccessors(owner);
    private final JunitLibraryAccessors laccForJunitLibraryAccessors = new JunitLibraryAccessors(owner);
    private final MockitoLibraryAccessors laccForMockitoLibraryAccessors = new MockitoLibraryAccessors(owner);
    private final MockserverLibraryAccessors laccForMockserverLibraryAccessors = new MockserverLibraryAccessors(owner);
    private final NimbusLibraryAccessors laccForNimbusLibraryAccessors = new NimbusLibraryAccessors(owner);
    private final OpentelemetryLibraryAccessors laccForOpentelemetryLibraryAccessors = new OpentelemetryLibraryAccessors(owner);
    private final Slf4jLibraryAccessors laccForSlf4jLibraryAccessors = new Slf4jLibraryAccessors(owner);
    private final VersionAccessors vaccForVersionAccessors = new VersionAccessors(providers, config);
    private final BundleAccessors baccForBundleAccessors = new BundleAccessors(objects, providers, config);
    private final PluginAccessors paccForPluginAccessors = new PluginAccessors(providers, config);

    @Inject
    public LibrariesForLibs(DefaultVersionCatalog config, ProviderFactory providers, ObjectFactory objects) {
        super(config, providers, objects);
    }

        /**
         * Creates a dependency provider for assertj (org.assertj:assertj-core)
         * This dependency was declared in catalog org.eclipse.edc:edc-versions:0.0.1-SNAPSHOT:20230113.055314-82
         */
        public Provider<MinimalExternalModuleDependency> getAssertj() { return create("assertj"); }

        /**
         * Creates a dependency provider for awaitility (org.awaitility:awaitility)
         * This dependency was declared in catalog org.eclipse.edc:edc-versions:0.0.1-SNAPSHOT:20230113.055314-82
         */
        public Provider<MinimalExternalModuleDependency> getAwaitility() { return create("awaitility"); }

        /**
         * Creates a dependency provider for cloudEvents (io.cloudevents:cloudevents-http-basic)
         * This dependency was declared in catalog org.eclipse.edc:edc-versions:0.0.1-SNAPSHOT:20230113.055314-82
         */
        public Provider<MinimalExternalModuleDependency> getCloudEvents() { return create("cloudEvents"); }

        /**
         * Creates a dependency provider for dnsOverHttps (com.squareup.okhttp3:okhttp-dnsoverhttps)
         * This dependency was declared in settings file 'settings.gradle.kts'
         */
        public Provider<MinimalExternalModuleDependency> getDnsOverHttps() { return create("dnsOverHttps"); }

        /**
         * Creates a dependency provider for gatling (io.gatling.highcharts:gatling-charts-highcharts)
         * This dependency was declared in catalog org.eclipse.edc:edc-versions:0.0.1-SNAPSHOT:20230113.055314-82
         */
        public Provider<MinimalExternalModuleDependency> getGatling() { return create("gatling"); }

        /**
         * Creates a dependency provider for h2 (com.h2database:h2)
         * This dependency was declared in catalog org.eclipse.edc:edc-versions:0.0.1-SNAPSHOT:20230113.055314-82
         */
        public Provider<MinimalExternalModuleDependency> getH2() { return create("h2"); }

        /**
         * Creates a dependency provider for jta (javax.transaction:javax.transaction-api)
         * This dependency was declared in catalog org.eclipse.edc:edc-versions:0.0.1-SNAPSHOT:20230113.055314-82
         */
        public Provider<MinimalExternalModuleDependency> getJta() { return create("jta"); }

        /**
         * Creates a dependency provider for micrometer (io.micrometer:micrometer-core)
         * This dependency was declared in catalog org.eclipse.edc:edc-versions:0.0.1-SNAPSHOT:20230113.055314-82
         */
        public Provider<MinimalExternalModuleDependency> getMicrometer() { return create("micrometer"); }

        /**
         * Creates a dependency provider for okhttp (com.squareup.okhttp3:okhttp)
         * This dependency was declared in catalog org.eclipse.edc:edc-versions:0.0.1-SNAPSHOT:20230113.055314-82
         */
        public Provider<MinimalExternalModuleDependency> getOkhttp() { return create("okhttp"); }

        /**
         * Creates a dependency provider for postgres (org.postgresql:postgresql)
         * This dependency was declared in catalog org.eclipse.edc:edc-versions:0.0.1-SNAPSHOT:20230113.055314-82
         */
        public Provider<MinimalExternalModuleDependency> getPostgres() { return create("postgres"); }

        /**
         * Creates a dependency provider for restAssured (io.rest-assured:rest-assured)
         * This dependency was declared in catalog org.eclipse.edc:edc-versions:0.0.1-SNAPSHOT:20230113.055314-82
         */
        public Provider<MinimalExternalModuleDependency> getRestAssured() { return create("restAssured"); }

    /**
     * Returns the group of libraries at apache
     */
    public ApacheLibraryAccessors getApache() { return laccForApacheLibraryAccessors; }

    /**
     * Returns the group of libraries at atomikos
     */
    public AtomikosLibraryAccessors getAtomikos() { return laccForAtomikosLibraryAccessors; }

    /**
     * Returns the group of libraries at aws
     */
    public AwsLibraryAccessors getAws() { return laccForAwsLibraryAccessors; }

    /**
     * Returns the group of libraries at azure
     */
    public AzureLibraryAccessors getAzure() { return laccForAzureLibraryAccessors; }

    /**
     * Returns the group of libraries at bouncyCastle
     */
    public BouncyCastleLibraryAccessors getBouncyCastle() { return laccForBouncyCastleLibraryAccessors; }

    /**
     * Returns the group of libraries at failsafe
     */
    public FailsafeLibraryAccessors getFailsafe() { return laccForFailsafeLibraryAccessors; }

    /**
     * Returns the group of libraries at fraunhofer
     */
    public FraunhoferLibraryAccessors getFraunhofer() { return laccForFraunhoferLibraryAccessors; }

    /**
     * Returns the group of libraries at googlecloud
     */
    public GooglecloudLibraryAccessors getGooglecloud() { return laccForGooglecloudLibraryAccessors; }

    /**
     * Returns the group of libraries at jackson
     */
    public JacksonLibraryAccessors getJackson() { return laccForJacksonLibraryAccessors; }

    /**
     * Returns the group of libraries at jakarta
     */
    public JakartaLibraryAccessors getJakarta() { return laccForJakartaLibraryAccessors; }

    /**
     * Returns the group of libraries at jersey
     */
    public JerseyLibraryAccessors getJersey() { return laccForJerseyLibraryAccessors; }

    /**
     * Returns the group of libraries at jetty
     */
    public JettyLibraryAccessors getJetty() { return laccForJettyLibraryAccessors; }

    /**
     * Returns the group of libraries at junit
     */
    public JunitLibraryAccessors getJunit() { return laccForJunitLibraryAccessors; }

    /**
     * Returns the group of libraries at mockito
     */
    public MockitoLibraryAccessors getMockito() { return laccForMockitoLibraryAccessors; }

    /**
     * Returns the group of libraries at mockserver
     */
    public MockserverLibraryAccessors getMockserver() { return laccForMockserverLibraryAccessors; }

    /**
     * Returns the group of libraries at nimbus
     */
    public NimbusLibraryAccessors getNimbus() { return laccForNimbusLibraryAccessors; }

    /**
     * Returns the group of libraries at opentelemetry
     */
    public OpentelemetryLibraryAccessors getOpentelemetry() { return laccForOpentelemetryLibraryAccessors; }

    /**
     * Returns the group of libraries at slf4j
     */
    public Slf4jLibraryAccessors getSlf4j() { return laccForSlf4jLibraryAccessors; }

    /**
     * Returns the group of versions at versions
     */
    public VersionAccessors getVersions() { return vaccForVersionAccessors; }

    /**
     * Returns the group of bundles at bundles
     */
    public BundleAccessors getBundles() { return baccForBundleAccessors; }

    /**
     * Returns the group of plugins at plugins
     */
    public PluginAccessors getPlugins() { return paccForPluginAccessors; }

    public static class ApacheLibraryAccessors extends SubDependencyFactory {
        private final ApacheCommonsLibraryAccessors laccForApacheCommonsLibraryAccessors = new ApacheCommonsLibraryAccessors(owner);

        public ApacheLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at apache.commons
         */
        public ApacheCommonsLibraryAccessors getCommons() { return laccForApacheCommonsLibraryAccessors; }

    }

    public static class ApacheCommonsLibraryAccessors extends SubDependencyFactory {

        public ApacheCommonsLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for pool (org.apache.commons:commons-pool2)
             * This dependency was declared in catalog org.eclipse.edc:edc-versions:0.0.1-SNAPSHOT:20230113.055314-82
             */
            public Provider<MinimalExternalModuleDependency> getPool() { return create("apache.commons.pool"); }

    }

    public static class AtomikosLibraryAccessors extends SubDependencyFactory {

        public AtomikosLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for jdbc (com.atomikos:transactions-jdbc)
             * This dependency was declared in catalog org.eclipse.edc:edc-versions:0.0.1-SNAPSHOT:20230113.055314-82
             */
            public Provider<MinimalExternalModuleDependency> getJdbc() { return create("atomikos.jdbc"); }

            /**
             * Creates a dependency provider for jta (com.atomikos:transactions-jta)
             * This dependency was declared in catalog org.eclipse.edc:edc-versions:0.0.1-SNAPSHOT:20230113.055314-82
             */
            public Provider<MinimalExternalModuleDependency> getJta() { return create("atomikos.jta"); }

    }

    public static class AwsLibraryAccessors extends SubDependencyFactory {

        public AwsLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for iam (software.amazon.awssdk:iam)
             * This dependency was declared in catalog org.eclipse.edc:edc-versions:0.0.1-SNAPSHOT:20230113.055314-82
             */
            public Provider<MinimalExternalModuleDependency> getIam() { return create("aws.iam"); }

            /**
             * Creates a dependency provider for s3 (software.amazon.awssdk:s3)
             * This dependency was declared in catalog org.eclipse.edc:edc-versions:0.0.1-SNAPSHOT:20230113.055314-82
             */
            public Provider<MinimalExternalModuleDependency> getS3() { return create("aws.s3"); }

            /**
             * Creates a dependency provider for sts (software.amazon.awssdk:sts)
             * This dependency was declared in catalog org.eclipse.edc:edc-versions:0.0.1-SNAPSHOT:20230113.055314-82
             */
            public Provider<MinimalExternalModuleDependency> getSts() { return create("aws.sts"); }

    }

    public static class AzureLibraryAccessors extends SubDependencyFactory {
        private final AzureResourcemanagerLibraryAccessors laccForAzureResourcemanagerLibraryAccessors = new AzureResourcemanagerLibraryAccessors(owner);

        public AzureLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for cosmos (com.azure:azure-cosmos)
             * This dependency was declared in catalog org.eclipse.edc:edc-versions:0.0.1-SNAPSHOT:20230113.055314-82
             */
            public Provider<MinimalExternalModuleDependency> getCosmos() { return create("azure.cosmos"); }

            /**
             * Creates a dependency provider for eventgrid (com.azure:azure-messaging-eventgrid)
             * This dependency was declared in catalog org.eclipse.edc:edc-versions:0.0.1-SNAPSHOT:20230113.055314-82
             */
            public Provider<MinimalExternalModuleDependency> getEventgrid() { return create("azure.eventgrid"); }

            /**
             * Creates a dependency provider for identity (com.azure:azure-identity)
             * This dependency was declared in catalog org.eclipse.edc:edc-versions:0.0.1-SNAPSHOT:20230113.055314-82
             */
            public Provider<MinimalExternalModuleDependency> getIdentity() { return create("azure.identity"); }

            /**
             * Creates a dependency provider for keyvault (com.azure:azure-security-keyvault-secrets)
             * This dependency was declared in catalog org.eclipse.edc:edc-versions:0.0.1-SNAPSHOT:20230113.055314-82
             */
            public Provider<MinimalExternalModuleDependency> getKeyvault() { return create("azure.keyvault"); }

            /**
             * Creates a dependency provider for storageblob (com.azure:azure-storage-blob)
             * This dependency was declared in catalog org.eclipse.edc:edc-versions:0.0.1-SNAPSHOT:20230113.055314-82
             */
            public Provider<MinimalExternalModuleDependency> getStorageblob() { return create("azure.storageblob"); }

        /**
         * Returns the group of libraries at azure.resourcemanager
         */
        public AzureResourcemanagerLibraryAccessors getResourcemanager() { return laccForAzureResourcemanagerLibraryAccessors; }

    }

    public static class AzureResourcemanagerLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {

        public AzureResourcemanagerLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for resourcemanager (com.azure.resourcemanager:azure-resourcemanager)
             * This dependency was declared in catalog org.eclipse.edc:edc-versions:0.0.1-SNAPSHOT:20230113.055314-82
             */
            public Provider<MinimalExternalModuleDependency> asProvider() { return create("azure.resourcemanager"); }

            /**
             * Creates a dependency provider for authorization (com.azure.resourcemanager:azure-resourcemanager-authorization)
             * This dependency was declared in catalog org.eclipse.edc:edc-versions:0.0.1-SNAPSHOT:20230113.055314-82
             */
            public Provider<MinimalExternalModuleDependency> getAuthorization() { return create("azure.resourcemanager.authorization"); }

            /**
             * Creates a dependency provider for datafactory (com.azure.resourcemanager:azure-resourcemanager-datafactory)
             * This dependency was declared in catalog org.eclipse.edc:edc-versions:0.0.1-SNAPSHOT:20230113.055314-82
             */
            public Provider<MinimalExternalModuleDependency> getDatafactory() { return create("azure.resourcemanager.datafactory"); }

            /**
             * Creates a dependency provider for keyvault (com.azure.resourcemanager:azure-resourcemanager-keyvault)
             * This dependency was declared in catalog org.eclipse.edc:edc-versions:0.0.1-SNAPSHOT:20230113.055314-82
             */
            public Provider<MinimalExternalModuleDependency> getKeyvault() { return create("azure.resourcemanager.keyvault"); }

            /**
             * Creates a dependency provider for storage (com.azure.resourcemanager:azure-resourcemanager-storage)
             * This dependency was declared in catalog org.eclipse.edc:edc-versions:0.0.1-SNAPSHOT:20230113.055314-82
             */
            public Provider<MinimalExternalModuleDependency> getStorage() { return create("azure.resourcemanager.storage"); }

    }

    public static class BouncyCastleLibraryAccessors extends SubDependencyFactory {

        public BouncyCastleLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for bcpkix (org.bouncycastle:bcpkix-jdk15on)
             * This dependency was declared in catalog org.eclipse.edc:edc-versions:0.0.1-SNAPSHOT:20230113.055314-82
             */
            public Provider<MinimalExternalModuleDependency> getBcpkix() { return create("bouncyCastle.bcpkix"); }

            /**
             * Creates a dependency provider for bcpkixJdk18on (org.bouncycastle:bcpkix-jdk18on)
             * This dependency was declared in catalog org.eclipse.edc:edc-versions:0.0.1-SNAPSHOT:20230113.055314-82
             */
            public Provider<MinimalExternalModuleDependency> getBcpkixJdk18on() { return create("bouncyCastle.bcpkixJdk18on"); }

            /**
             * Creates a dependency provider for bcprov (org.bouncycastle:bcprov-jdk15on)
             * This dependency was declared in catalog org.eclipse.edc:edc-versions:0.0.1-SNAPSHOT:20230113.055314-82
             */
            public Provider<MinimalExternalModuleDependency> getBcprov() { return create("bouncyCastle.bcprov"); }

            /**
             * Creates a dependency provider for bcprovJdk18on (org.bouncycastle:bcprov-jdk18on)
             * This dependency was declared in catalog org.eclipse.edc:edc-versions:0.0.1-SNAPSHOT:20230113.055314-82
             */
            public Provider<MinimalExternalModuleDependency> getBcprovJdk18on() { return create("bouncyCastle.bcprovJdk18on"); }

    }

    public static class FailsafeLibraryAccessors extends SubDependencyFactory {

        public FailsafeLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for core (dev.failsafe:failsafe)
             * This dependency was declared in catalog org.eclipse.edc:edc-versions:0.0.1-SNAPSHOT:20230113.055314-82
             */
            public Provider<MinimalExternalModuleDependency> getCore() { return create("failsafe.core"); }

            /**
             * Creates a dependency provider for okhttp (dev.failsafe:failsafe-okhttp)
             * This dependency was declared in catalog org.eclipse.edc:edc-versions:0.0.1-SNAPSHOT:20230113.055314-82
             */
            public Provider<MinimalExternalModuleDependency> getOkhttp() { return create("failsafe.okhttp"); }

    }

    public static class FraunhoferLibraryAccessors extends SubDependencyFactory {

        public FraunhoferLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for infomodel (de.fraunhofer.iais.eis.ids.infomodel:java)
             * This dependency was declared in catalog org.eclipse.edc:edc-versions:0.0.1-SNAPSHOT:20230113.055314-82
             */
            public Provider<MinimalExternalModuleDependency> getInfomodel() { return create("fraunhofer.infomodel"); }

    }

    public static class GooglecloudLibraryAccessors extends SubDependencyFactory {
        private final GooglecloudIamLibraryAccessors laccForGooglecloudIamLibraryAccessors = new GooglecloudIamLibraryAccessors(owner);

        public GooglecloudLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for storage (com.google.cloud:google-cloud-storage)
             * This dependency was declared in catalog org.eclipse.edc:edc-versions:0.0.1-SNAPSHOT:20230113.055314-82
             */
            public Provider<MinimalExternalModuleDependency> getStorage() { return create("googlecloud.storage"); }

        /**
         * Returns the group of libraries at googlecloud.iam
         */
        public GooglecloudIamLibraryAccessors getIam() { return laccForGooglecloudIamLibraryAccessors; }

    }

    public static class GooglecloudIamLibraryAccessors extends SubDependencyFactory {

        public GooglecloudIamLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for admin (com.google.cloud:google-iam-admin)
             * This dependency was declared in catalog org.eclipse.edc:edc-versions:0.0.1-SNAPSHOT:20230113.055314-82
             */
            public Provider<MinimalExternalModuleDependency> getAdmin() { return create("googlecloud.iam.admin"); }

            /**
             * Creates a dependency provider for credentials (com.google.cloud:google-cloud-iamcredentials)
             * This dependency was declared in catalog org.eclipse.edc:edc-versions:0.0.1-SNAPSHOT:20230113.055314-82
             */
            public Provider<MinimalExternalModuleDependency> getCredentials() { return create("googlecloud.iam.credentials"); }

    }

    public static class JacksonLibraryAccessors extends SubDependencyFactory {

        public JacksonLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for annotations (com.fasterxml.jackson.core:jackson-annotations)
             * This dependency was declared in catalog org.eclipse.edc:edc-versions:0.0.1-SNAPSHOT:20230113.055314-82
             */
            public Provider<MinimalExternalModuleDependency> getAnnotations() { return create("jackson.annotations"); }

            /**
             * Creates a dependency provider for core (com.fasterxml.jackson.core:jackson-core)
             * This dependency was declared in catalog org.eclipse.edc:edc-versions:0.0.1-SNAPSHOT:20230113.055314-82
             */
            public Provider<MinimalExternalModuleDependency> getCore() { return create("jackson.core"); }

            /**
             * Creates a dependency provider for databind (com.fasterxml.jackson.core:jackson-databind)
             * This dependency was declared in catalog org.eclipse.edc:edc-versions:0.0.1-SNAPSHOT:20230113.055314-82
             */
            public Provider<MinimalExternalModuleDependency> getDatabind() { return create("jackson.databind"); }

            /**
             * Creates a dependency provider for datatypeJsr310 (com.fasterxml.jackson.datatype:jackson-datatype-jsr310)
             * This dependency was declared in catalog org.eclipse.edc:edc-versions:0.0.1-SNAPSHOT:20230113.055314-82
             */
            public Provider<MinimalExternalModuleDependency> getDatatypeJsr310() { return create("jackson.datatypeJsr310"); }

    }

    public static class JakartaLibraryAccessors extends SubDependencyFactory {

        public JakartaLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for rsApi (jakarta.ws.rs:jakarta.ws.rs-api)
             * This dependency was declared in catalog org.eclipse.edc:edc-versions:0.0.1-SNAPSHOT:20230113.055314-82
             */
            public Provider<MinimalExternalModuleDependency> getRsApi() { return create("jakarta.rsApi"); }

            /**
             * Creates a dependency provider for validation (jakarta.validation:jakarta.validation-api)
             * This dependency was declared in catalog org.eclipse.edc:edc-versions:0.0.1-SNAPSHOT:20230113.055314-82
             */
            public Provider<MinimalExternalModuleDependency> getValidation() { return create("jakarta.validation"); }

    }

    public static class JerseyLibraryAccessors extends SubDependencyFactory {

        public JerseyLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for beanvalidation (org.glassfish.jersey.ext:jersey-bean-validation)
             * This dependency was declared in catalog org.eclipse.edc:edc-versions:0.0.1-SNAPSHOT:20230113.055314-82
             */
            public Provider<MinimalExternalModuleDependency> getBeanvalidation() { return create("jersey.beanvalidation"); }

            /**
             * Creates a dependency provider for common (org.glassfish.jersey.core:jersey-common)
             * This dependency was declared in catalog org.eclipse.edc:edc-versions:0.0.1-SNAPSHOT:20230113.055314-82
             */
            public Provider<MinimalExternalModuleDependency> getCommon() { return create("jersey.common"); }

            /**
             * Creates a dependency provider for inject (org.glassfish.jersey.inject:jersey-hk2)
             * This dependency was declared in catalog org.eclipse.edc:edc-versions:0.0.1-SNAPSHOT:20230113.055314-82
             */
            public Provider<MinimalExternalModuleDependency> getInject() { return create("jersey.inject"); }

            /**
             * Creates a dependency provider for jackson (org.glassfish.jersey.media:jersey-media-json-jackson)
             * This dependency was declared in catalog org.eclipse.edc:edc-versions:0.0.1-SNAPSHOT:20230113.055314-82
             */
            public Provider<MinimalExternalModuleDependency> getJackson() { return create("jersey.jackson"); }

            /**
             * Creates a dependency provider for multipart (org.glassfish.jersey.media:jersey-media-multipart)
             * This dependency was declared in catalog org.eclipse.edc:edc-versions:0.0.1-SNAPSHOT:20230113.055314-82
             */
            public Provider<MinimalExternalModuleDependency> getMultipart() { return create("jersey.multipart"); }

            /**
             * Creates a dependency provider for server (org.glassfish.jersey.core:jersey-server)
             * This dependency was declared in catalog org.eclipse.edc:edc-versions:0.0.1-SNAPSHOT:20230113.055314-82
             */
            public Provider<MinimalExternalModuleDependency> getServer() { return create("jersey.server"); }

            /**
             * Creates a dependency provider for servlet (org.glassfish.jersey.containers:jersey-container-servlet)
             * This dependency was declared in catalog org.eclipse.edc:edc-versions:0.0.1-SNAPSHOT:20230113.055314-82
             */
            public Provider<MinimalExternalModuleDependency> getServlet() { return create("jersey.servlet"); }

            /**
             * Creates a dependency provider for servletcore (org.glassfish.jersey.containers:jersey-container-servlet-core)
             * This dependency was declared in catalog org.eclipse.edc:edc-versions:0.0.1-SNAPSHOT:20230113.055314-82
             */
            public Provider<MinimalExternalModuleDependency> getServletcore() { return create("jersey.servletcore"); }

    }

    public static class JettyLibraryAccessors extends SubDependencyFactory {

        public JettyLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for websocket (org.eclipse.jetty.websocket:websocket-jakarta-server)
             * This dependency was declared in catalog org.eclipse.edc:edc-versions:0.0.1-SNAPSHOT:20230113.055314-82
             */
            public Provider<MinimalExternalModuleDependency> getWebsocket() { return create("jetty.websocket"); }

    }

    public static class JunitLibraryAccessors extends SubDependencyFactory {
        private final JunitJupiterLibraryAccessors laccForJunitJupiterLibraryAccessors = new JunitJupiterLibraryAccessors(owner);

        public JunitLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at junit.jupiter
         */
        public JunitJupiterLibraryAccessors getJupiter() { return laccForJunitJupiterLibraryAccessors; }

    }

    public static class JunitJupiterLibraryAccessors extends SubDependencyFactory {

        public JunitJupiterLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for api (org.junit.jupiter:junit-jupiter-api)
             * This dependency was declared in catalog org.eclipse.edc:edc-versions:0.0.1-SNAPSHOT:20230113.055314-82
             */
            public Provider<MinimalExternalModuleDependency> getApi() { return create("junit.jupiter.api"); }

            /**
             * Creates a dependency provider for engine (org.junit.jupiter:junit-jupiter-engine)
             * This dependency was declared in catalog org.eclipse.edc:edc-versions:0.0.1-SNAPSHOT:20230113.055314-82
             */
            public Provider<MinimalExternalModuleDependency> getEngine() { return create("junit.jupiter.engine"); }

            /**
             * Creates a dependency provider for params (org.junit.jupiter:junit-jupiter-params)
             * This dependency was declared in catalog org.eclipse.edc:edc-versions:0.0.1-SNAPSHOT:20230113.055314-82
             */
            public Provider<MinimalExternalModuleDependency> getParams() { return create("junit.jupiter.params"); }

    }

    public static class MockitoLibraryAccessors extends SubDependencyFactory {

        public MockitoLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for core (org.mockito:mockito-core)
             * This dependency was declared in catalog org.eclipse.edc:edc-versions:0.0.1-SNAPSHOT:20230113.055314-82
             */
            public Provider<MinimalExternalModuleDependency> getCore() { return create("mockito.core"); }

            /**
             * Creates a dependency provider for inline (org.mockito:mockito-inline)
             * This dependency was declared in catalog org.eclipse.edc:edc-versions:0.0.1-SNAPSHOT:20230113.055314-82
             */
            public Provider<MinimalExternalModuleDependency> getInline() { return create("mockito.inline"); }

    }

    public static class MockserverLibraryAccessors extends SubDependencyFactory {

        public MockserverLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for client (org.mock-server:mockserver-client-java)
             * This dependency was declared in catalog org.eclipse.edc:edc-versions:0.0.1-SNAPSHOT:20230113.055314-82
             */
            public Provider<MinimalExternalModuleDependency> getClient() { return create("mockserver.client"); }

            /**
             * Creates a dependency provider for netty (org.mock-server:mockserver-netty)
             * This dependency was declared in catalog org.eclipse.edc:edc-versions:0.0.1-SNAPSHOT:20230113.055314-82
             */
            public Provider<MinimalExternalModuleDependency> getNetty() { return create("mockserver.netty"); }

    }

    public static class NimbusLibraryAccessors extends SubDependencyFactory {

        public NimbusLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for jwt (com.nimbusds:nimbus-jose-jwt)
             * This dependency was declared in catalog org.eclipse.edc:edc-versions:0.0.1-SNAPSHOT:20230113.055314-82
             */
            public Provider<MinimalExternalModuleDependency> getJwt() { return create("nimbus.jwt"); }

    }

    public static class OpentelemetryLibraryAccessors extends SubDependencyFactory {

        public OpentelemetryLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for annotations (io.opentelemetry:opentelemetry-extension-annotations)
             * This dependency was declared in catalog org.eclipse.edc:edc-versions:0.0.1-SNAPSHOT:20230113.055314-82
             */
            public Provider<MinimalExternalModuleDependency> getAnnotations() { return create("opentelemetry.annotations"); }

            /**
             * Creates a dependency provider for api (io.opentelemetry:opentelemetry-api)
             * This dependency was declared in catalog org.eclipse.edc:edc-versions:0.0.1-SNAPSHOT:20230113.055314-82
             */
            public Provider<MinimalExternalModuleDependency> getApi() { return create("opentelemetry.api"); }

    }

    public static class Slf4jLibraryAccessors extends SubDependencyFactory {

        public Slf4jLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for api (org.slf4j:slf4j-api)
             * This dependency was declared in catalog org.eclipse.edc:edc-versions:0.0.1-SNAPSHOT:20230113.055314-82
             */
            public Provider<MinimalExternalModuleDependency> getApi() { return create("slf4j.api"); }

    }

    public static class VersionAccessors extends VersionFactory  {

        private final AzureVersionAccessors vaccForAzureVersionAccessors = new AzureVersionAccessors(providers, config);
        private final BouncyCastleVersionAccessors vaccForBouncyCastleVersionAccessors = new BouncyCastleVersionAccessors(providers, config);
        public VersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: apacheCommonsPool2 (2.11.1)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog org.eclipse.edc:edc-versions:0.0.1-SNAPSHOT:20230113.055314-82
             */
            public Provider<String> getApacheCommonsPool2() { return getVersion("apacheCommonsPool2"); }

            /**
             * Returns the version associated to this alias: assertj (3.22.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog org.eclipse.edc:edc-versions:0.0.1-SNAPSHOT:20230113.055314-82
             */
            public Provider<String> getAssertj() { return getVersion("assertj"); }

            /**
             * Returns the version associated to this alias: atomikos (5.0.8)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog org.eclipse.edc:edc-versions:0.0.1-SNAPSHOT:20230113.055314-82
             */
            public Provider<String> getAtomikos() { return getVersion("atomikos"); }

            /**
             * Returns the version associated to this alias: awaitility (4.2.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog org.eclipse.edc:edc-versions:0.0.1-SNAPSHOT:20230113.055314-82
             */
            public Provider<String> getAwaitility() { return getVersion("awaitility"); }

            /**
             * Returns the version associated to this alias: aws (2.17.288)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog org.eclipse.edc:edc-versions:0.0.1-SNAPSHOT:20230113.055314-82
             */
            public Provider<String> getAws() { return getVersion("aws"); }

            /**
             * Returns the version associated to this alias: cloudEvents (2.3.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog org.eclipse.edc:edc-versions:0.0.1-SNAPSHOT:20230113.055314-82
             */
            public Provider<String> getCloudEvents() { return getVersion("cloudEvents"); }

            /**
             * Returns the version associated to this alias: failsafe (3.2.4)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog org.eclipse.edc:edc-versions:0.0.1-SNAPSHOT:20230113.055314-82
             */
            public Provider<String> getFailsafe() { return getVersion("failsafe"); }

            /**
             * Returns the version associated to this alias: gatling (3.7.5)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog org.eclipse.edc:edc-versions:0.0.1-SNAPSHOT:20230113.055314-82
             */
            public Provider<String> getGatling() { return getVersion("gatling"); }

            /**
             * Returns the version associated to this alias: googleCloudIamAdmin (1.2.5)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog org.eclipse.edc:edc-versions:0.0.1-SNAPSHOT:20230113.055314-82
             */
            public Provider<String> getGoogleCloudIamAdmin() { return getVersion("googleCloudIamAdmin"); }

            /**
             * Returns the version associated to this alias: googleCloudIamCredentials (2.3.5)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog org.eclipse.edc:edc-versions:0.0.1-SNAPSHOT:20230113.055314-82
             */
            public Provider<String> getGoogleCloudIamCredentials() { return getVersion("googleCloudIamCredentials"); }

            /**
             * Returns the version associated to this alias: googleCloudStorage (2.12.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog org.eclipse.edc:edc-versions:0.0.1-SNAPSHOT:20230113.055314-82
             */
            public Provider<String> getGoogleCloudStorage() { return getVersion("googleCloudStorage"); }

            /**
             * Returns the version associated to this alias: h2 (2.1.210)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog org.eclipse.edc:edc-versions:0.0.1-SNAPSHOT:20230113.055314-82
             */
            public Provider<String> getH2() { return getVersion("h2"); }

            /**
             * Returns the version associated to this alias: httpMockServer (5.14.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog org.eclipse.edc:edc-versions:0.0.1-SNAPSHOT:20230113.055314-82
             */
            public Provider<String> getHttpMockServer() { return getVersion("httpMockServer"); }

            /**
             * Returns the version associated to this alias: infomodel (4.1.3)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog org.eclipse.edc:edc-versions:0.0.1-SNAPSHOT:20230113.055314-82
             */
            public Provider<String> getInfomodel() { return getVersion("infomodel"); }

            /**
             * Returns the version associated to this alias: jackson (2.14.0-rc2)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog org.eclipse.edc:edc-versions:0.0.1-SNAPSHOT:20230113.055314-82
             */
            public Provider<String> getJackson() { return getVersion("jackson"); }

            /**
             * Returns the version associated to this alias: jakartaValidation (3.0.2)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog org.eclipse.edc:edc-versions:0.0.1-SNAPSHOT:20230113.055314-82
             */
            public Provider<String> getJakartaValidation() { return getVersion("jakartaValidation"); }

            /**
             * Returns the version associated to this alias: jersey (3.0.8)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog org.eclipse.edc:edc-versions:0.0.1-SNAPSHOT:20230113.055314-82
             */
            public Provider<String> getJersey() { return getVersion("jersey"); }

            /**
             * Returns the version associated to this alias: jetbrainsAnnotation (15.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog org.eclipse.edc:edc-versions:0.0.1-SNAPSHOT:20230113.055314-82
             */
            public Provider<String> getJetbrainsAnnotation() { return getVersion("jetbrainsAnnotation"); }

            /**
             * Returns the version associated to this alias: jetty (11.0.12)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog org.eclipse.edc:edc-versions:0.0.1-SNAPSHOT:20230113.055314-82
             */
            public Provider<String> getJetty() { return getVersion("jetty"); }

            /**
             * Returns the version associated to this alias: jta (1.3)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog org.eclipse.edc:edc-versions:0.0.1-SNAPSHOT:20230113.055314-82
             */
            public Provider<String> getJta() { return getVersion("jta"); }

            /**
             * Returns the version associated to this alias: jupiter (5.8.2)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog org.eclipse.edc:edc-versions:0.0.1-SNAPSHOT:20230113.055314-82
             */
            public Provider<String> getJupiter() { return getVersion("jupiter"); }

            /**
             * Returns the version associated to this alias: jwt (3.13.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog org.eclipse.edc:edc-versions:0.0.1-SNAPSHOT:20230113.055314-82
             */
            public Provider<String> getJwt() { return getVersion("jwt"); }

            /**
             * Returns the version associated to this alias: micrometer (1.8.2)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog org.eclipse.edc:edc-versions:0.0.1-SNAPSHOT:20230113.055314-82
             */
            public Provider<String> getMicrometer() { return getVersion("micrometer"); }

            /**
             * Returns the version associated to this alias: mockito (4.2.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog org.eclipse.edc:edc-versions:0.0.1-SNAPSHOT:20230113.055314-82
             */
            public Provider<String> getMockito() { return getVersion("mockito"); }

            /**
             * Returns the version associated to this alias: nimbus (9.25)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog org.eclipse.edc:edc-versions:0.0.1-SNAPSHOT:20230113.055314-82
             */
            public Provider<String> getNimbus() { return getVersion("nimbus"); }

            /**
             * Returns the version associated to this alias: okhttp (4.10.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog org.eclipse.edc:edc-versions:0.0.1-SNAPSHOT:20230113.055314-82
             */
            public Provider<String> getOkhttp() { return getVersion("okhttp"); }

            /**
             * Returns the version associated to this alias: openTelemetry (1.12.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog org.eclipse.edc:edc-versions:0.0.1-SNAPSHOT:20230113.055314-82
             */
            public Provider<String> getOpenTelemetry() { return getVersion("openTelemetry"); }

            /**
             * Returns the version associated to this alias: postgres (42.4.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog org.eclipse.edc:edc-versions:0.0.1-SNAPSHOT:20230113.055314-82
             */
            public Provider<String> getPostgres() { return getVersion("postgres"); }

            /**
             * Returns the version associated to this alias: restAssured (4.5.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog org.eclipse.edc:edc-versions:0.0.1-SNAPSHOT:20230113.055314-82
             */
            public Provider<String> getRestAssured() { return getVersion("restAssured"); }

            /**
             * Returns the version associated to this alias: rsApi (3.1.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog org.eclipse.edc:edc-versions:0.0.1-SNAPSHOT:20230113.055314-82
             */
            public Provider<String> getRsApi() { return getVersion("rsApi"); }

            /**
             * Returns the version associated to this alias: servletApi (4.0.4)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog org.eclipse.edc:edc-versions:0.0.1-SNAPSHOT:20230113.055314-82
             */
            public Provider<String> getServletApi() { return getVersion("servletApi"); }

            /**
             * Returns the version associated to this alias: slf4j (2.0.0-alpha7)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog org.eclipse.edc:edc-versions:0.0.1-SNAPSHOT:20230113.055314-82
             */
            public Provider<String> getSlf4j() { return getVersion("slf4j"); }

        /**
         * Returns the group of versions at versions.azure
         */
        public AzureVersionAccessors getAzure() { return vaccForAzureVersionAccessors; }

        /**
         * Returns the group of versions at versions.bouncyCastle
         */
        public BouncyCastleVersionAccessors getBouncyCastle() { return vaccForBouncyCastleVersionAccessors; }

    }

    public static class AzureVersionAccessors extends VersionFactory  {

        public AzureVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: azure.rm (2.12.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog org.eclipse.edc:edc-versions:0.0.1-SNAPSHOT:20230113.055314-82
             */
            public Provider<String> getRm() { return getVersion("azure.rm"); }

    }

    public static class BouncyCastleVersionAccessors extends VersionFactory  implements VersionNotationSupplier {

        public BouncyCastleVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the version associated to this alias: bouncyCastle (1.70)
         * If the version is a rich version and that its not expressible as a
         * single version string, then an empty string is returned.
         * This version was declared in catalog org.eclipse.edc:edc-versions:0.0.1-SNAPSHOT:20230113.055314-82
         */
        public Provider<String> asProvider() { return getVersion("bouncyCastle"); }

            /**
             * Returns the version associated to this alias: bouncyCastle.jdk18on (1.72)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog org.eclipse.edc:edc-versions:0.0.1-SNAPSHOT:20230113.055314-82
             */
            public Provider<String> getJdk18on() { return getVersion("bouncyCastle.jdk18on"); }

    }

    public static class BundleAccessors extends BundleFactory {
        private final JerseyBundleAccessors baccForJerseyBundleAccessors = new JerseyBundleAccessors(objects, providers, config);

        public BundleAccessors(ObjectFactory objects, ProviderFactory providers, DefaultVersionCatalog config) { super(objects, providers, config); }

            /**
             * Creates a dependency bundle provider for jackson which is an aggregate for the following dependencies:
             * <ul>
             *    <li>com.fasterxml.jackson.core:jackson-core</li>
             *    <li>com.fasterxml.jackson.core:jackson-annotations</li>
             *    <li>com.fasterxml.jackson.core:jackson-databind</li>
             *    <li>com.fasterxml.jackson.datatype:jackson-datatype-jsr310</li>
             * </ul>
             * This bundle was declared in catalog org.eclipse.edc:edc-versions:0.0.1-SNAPSHOT:20230113.055314-82
             */
            public Provider<ExternalModuleDependencyBundle> getJackson() { return createBundle("jackson"); }

            /**
             * Creates a dependency bundle provider for jupiter which is an aggregate for the following dependencies:
             * <ul>
             *    <li>org.junit.jupiter:junit-jupiter-api</li>
             *    <li>org.junit.jupiter:junit-jupiter-params</li>
             * </ul>
             * This bundle was declared in catalog org.eclipse.edc:edc-versions:0.0.1-SNAPSHOT:20230113.055314-82
             */
            public Provider<ExternalModuleDependencyBundle> getJupiter() { return createBundle("jupiter"); }

        /**
         * Returns the group of bundles at bundles.jersey
         */
        public JerseyBundleAccessors getJersey() { return baccForJerseyBundleAccessors; }

    }

    public static class JerseyBundleAccessors extends BundleFactory {

        public JerseyBundleAccessors(ObjectFactory objects, ProviderFactory providers, DefaultVersionCatalog config) { super(objects, providers, config); }

            /**
             * Creates a dependency bundle provider for jersey.api which is an aggregate for the following dependencies:
             * <ul>
             *    <li>org.glassfish.jersey.ext:jersey-bean-validation</li>
             *    <li>org.glassfish.jersey.core:jersey-common</li>
             *    <li>org.glassfish.jersey.core:jersey-server</li>
             * </ul>
             * This bundle was declared in catalog org.eclipse.edc:edc-versions:0.0.1-SNAPSHOT:20230113.055314-82
             */
            public Provider<ExternalModuleDependencyBundle> getApi() { return createBundle("jersey.api"); }

            /**
             * Creates a dependency bundle provider for jersey.core which is an aggregate for the following dependencies:
             * <ul>
             *    <li>org.glassfish.jersey.core:jersey-server</li>
             *    <li>org.glassfish.jersey.core:jersey-common</li>
             *    <li>org.glassfish.jersey.media:jersey-media-json-jackson</li>
             *    <li>org.glassfish.jersey.media:jersey-media-multipart</li>
             *    <li>org.glassfish.jersey.inject:jersey-hk2</li>
             *    <li>org.glassfish.jersey.containers:jersey-container-servlet</li>
             *    <li>org.glassfish.jersey.containers:jersey-container-servlet-core</li>
             * </ul>
             * This bundle was declared in catalog org.eclipse.edc:edc-versions:0.0.1-SNAPSHOT:20230113.055314-82
             */
            public Provider<ExternalModuleDependencyBundle> getCore() { return createBundle("jersey.core"); }

    }

    public static class PluginAccessors extends PluginFactory {

        public PluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

    }

}
