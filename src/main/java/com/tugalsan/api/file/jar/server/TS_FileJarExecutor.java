package com.tugalsan.api.file.jar.server;

import com.tugalsan.api.file.properties.server.TS_FilePropertiesUtils;
import com.tugalsan.api.log.server.TS_Log;
import com.tugalsan.api.random.server.TS_RandomUtils;
import com.tugalsan.api.unsafe.client.TGS_UnSafe;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class TS_FileJarExecutor {

    final private static TS_Log d = TS_Log.of(TS_FileJarExecutor.class);

    final public Path pathDriver;

    public TS_FileJarExecutor(Path jar, List<Path> criticalSourceFiles, List<TS_FilePropertiesUtils> params) {
        TGS_UnSafe.run(() -> {
            var pathFolderTmp = Files.createTempDirectory("tmp").toAbsolutePath();
            var pathFileTmpConfig = pathFolderTmp.resolve(TS_RandomUtils.nextUUIDType4());

        });

        TS_FilePropertiesUtils.setAllItems(criticalSourceFiles, items, true);
        this.pathDriver = jar;
    }

}
