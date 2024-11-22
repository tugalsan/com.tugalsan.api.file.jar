module com.tugalsan.api.file.jar {
    requires com.tugalsan.api.log;
    requires com.tugalsan.api.unsafe;
    requires com.tugalsan.api.file;
    requires com.tugalsan.api.file.properties;
    requires com.tugalsan.api.list;
    requires com.tugalsan.api.stream;
    requires com.tugalsan.api.random;
    requires com.tugalsan.api.string;
    exports com.tugalsan.api.file.jar.server;
}
