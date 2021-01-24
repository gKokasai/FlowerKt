package com.kokasai.flowerkt.database

import com.kokasai.flowerkt.module.UseModule

interface UseDatabase : UseModule {
    /**
     * データベース
     */
    val databaseProvider: DatabaseProvider
}
