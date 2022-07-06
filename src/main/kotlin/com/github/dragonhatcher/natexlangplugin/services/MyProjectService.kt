package com.github.dragonhatcher.natexlangplugin.services

import com.intellij.openapi.project.Project
import com.github.dragonhatcher.natexlangplugin.MyBundle

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
