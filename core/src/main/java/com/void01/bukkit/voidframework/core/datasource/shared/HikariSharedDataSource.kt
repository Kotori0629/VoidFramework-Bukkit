package com.void01.bukkit.voidframework.core.datasource.shared

import com.void01.bukkit.voidframework.api.common.datasource.shared.SharedDataSource
import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.bukkit.configuration.ConfigurationSection
import java.io.PrintWriter
import java.sql.Connection
import java.util.*
import java.util.logging.Logger

class HikariSharedDataSource : SharedDataSource {
    private lateinit var hikariDataSource: HikariDataSource

    override fun loadConfig(section: ConfigurationSection) {
        val properties = Properties()

        section.getKeys(false).forEach {
            properties[it] = section.get(it)
        }

        hikariDataSource = HikariDataSource(HikariConfig(properties))
    }

    override fun close() {
        hikariDataSource.close()
    }

    override fun getLogWriter(): PrintWriter {

        return hikariDataSource.logWriter
    }

    override fun setLogWriter(out: PrintWriter?) {
        hikariDataSource.logWriter = out
    }

    override fun setLoginTimeout(seconds: Int) {
        hikariDataSource.loginTimeout = seconds
    }

    override fun getLoginTimeout(): Int {
        return hikariDataSource.loginTimeout
    }

    override fun getParentLogger(): Logger {
        return hikariDataSource.parentLogger
    }

    override fun <T : Any?> unwrap(iface: Class<T>?): T {
        return hikariDataSource.unwrap(iface)
    }

    override fun isWrapperFor(iface: Class<*>?): Boolean {
        return hikariDataSource.isWrapperFor(iface)
    }

    override fun getConnection(): Connection {
        return hikariDataSource.connection
    }

    override fun getConnection(username: String?, password: String?): Connection {
        return hikariDataSource.getConnection(username, password)
    }
}