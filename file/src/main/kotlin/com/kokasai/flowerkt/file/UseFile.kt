package com.kokasai.flowerkt.file

import com.kokasai.flowerkt.module.UseModule

interface UseFile : UseModule {
    /**
     * ファイルの保存先
     */
    val fileProvider: FileProvider
}
