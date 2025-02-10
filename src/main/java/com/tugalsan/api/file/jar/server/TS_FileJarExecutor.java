package com.tugalsan.api.file.jar.server;

import com.tugalsan.api.file.properties.server.TS_FilePropertiesUtils;
import com.tugalsan.api.file.server.TS_FileUtils;
import com.tugalsan.api.function.client.maythrow.uncheckedexceptions.TGS_FuncMTUCE_In1;
import com.tugalsan.api.log.server.TS_Log;
import com.tugalsan.api.os.server.TS_OsJavaUtils;
import com.tugalsan.api.random.server.TS_RandomUtils;
import com.tugalsan.api.function.client.maythrow.checkedexceptions.TGS_FuncMTCEUtils;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class TS_FileJarExecutor {

    final private static TS_Log d = TS_Log.of(TS_FileJarExecutor.class);

    final public Path pathDriver;

    private static String inQuotes(Path path) {
        return "\"" + path.toAbsolutePath() + "\"";
    }

    public TS_FileJarExecutor(Path pathJar, TGS_FuncMTUCE_In1<List<String>> args_0fileJavaExe_1tagJar_2jarPath_3fileConfig, List<Path> filesToBeCopiedToTmp, List<TS_FilePropertiesUtils> executionParams) {
        TGS_FuncMTCEUtils.run(() -> {
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

        TS_FilePropertiesUtils.setAllItems(filesToBeCopiedToTmp, items, true);
        this.pathDriver = pathJar;
    }

}
