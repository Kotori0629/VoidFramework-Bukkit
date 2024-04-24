package com.void01.bukkit.voidframework.api.common.mongodb

import com.mongodb.client.MongoClient

interface MongoDbManager {
    @Deprecated(message = "命名优化")
    fun getSharedMongoDbClientOrNull(id: String): Any?

    @Deprecated(message = "命名优化")
    fun getSharedMongoDbClient(id: String): Any

    @Deprecated(message = "返回类型不明确")
    fun getSharedClientOrNull(id: String): Any?

    @Deprecated(message = "返回类型不明确")
    fun getSharedClient(id: String): Any

    @Deprecated(message = "命名优化")
    fun getSharedClientOrNull2(id: String): MongoClient?

    @Deprecated(message = "命名优化")
    fun getSharedClient2(id: String): MongoClient

    fun getClient(id: String): MongoClient

    fun getClientOrNull(id: String): MongoClient?
}