package com.tugalsan.api.file.jar.server;

import module com.tugalsan.api.file.properties;
import module com.tugalsan.api.file;
import module com.tugalsan.api.log;
import module com.tugalsan.api.os;
import module com.tugalsan.api.random;
import module com.tugalsan.api.function;
import java.nio.file.*;
import java.util.*;
import java.util.List;

public class TS_FileJarExecutor {

    final private static TS_Log d = TS_Log.of(TS_FileJarExecutor.class);
    final public Path pathDriver;

    private static String inQuotes(Path path) {
        return "\"" + path.toAbsolutePath() + "\"";
    }

    @Deprecated //TODO
    public TS_FileJarExecutor(Path pathJar, TGS_FuncMTU_In1<List<String>> args_0fileJavaExe_1tagJar_2jarPath_3fileConfig, List<Path> filesToBeCopiedToTmp, List<TS_FilePropertiesUtils> executionParams) {
        TGS_FuncMTCUtils.run(() -> {
            var pathTmp = Files.createTempDirectory("tmp").toAbsolutePath();
            filesToBeCopiedToTmp.forEach(orgFile -> {
                var tmpFile = pathTmp.resolve(TS_RandomUtils.nextUUIDType4());
                TS_FileUtils.copyAs(orgFile, tmpFile, true);
            });
            var pathJava = TS_OsJavaUtils.getPathJava().resolveSibling("java.exe");
            var pathConfig = pathTmp.resolve(TS_RandomUtils.nextUUIDType4());
            List<String> _args = new ArrayList();
            _args.add(inQuotes(pathJava));
            _args.add("-jar");
            _args.add(inQuotes(pathJar));
        });
        var items = new ArrayList<TS_FilePropertiesItem>();
        TS_FilePropertiesUtils.setAllItems(filesToBeCopiedToTmp, items, true);
        this.pathDriver = pathJar;
    }

}
