package com.github.madwareru.intellijsignificantwhitespacelang.services

import com.intellij.openapi.project.Project
import com.github.madwareru.intellijsignificantwhitespacelang.MyBundle

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
