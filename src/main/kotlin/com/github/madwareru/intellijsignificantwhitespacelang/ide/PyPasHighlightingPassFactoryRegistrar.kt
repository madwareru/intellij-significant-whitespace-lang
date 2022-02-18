package com.github.madwareru.intellijsignificantwhitespacelang.ide

import com.github.madwareru.intellijsignificantwhitespacelang.language.psi.PyPasFile
import com.intellij.codeHighlighting.*
import com.intellij.openapi.editor.Document
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.progress.ProgressIndicator
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiFile

class PyPasHighlightingPassFactoryRegistrar : TextEditorHighlightingPassFactoryRegistrar {
    override fun registerHighlightingPassFactory(registrar: TextEditorHighlightingPassRegistrar, project: Project) {
        registrar.registerTextEditorHighlightingPass(
            PyPasHighlightingPassFactory(),
            /* anchor = */ TextEditorHighlightingPassRegistrar.Anchor.AFTER,
            /* anchorPassId = */ Pass.UPDATE_FOLDING,
            /* needAdditionalIntentionsPass = */ false,
            /* inPostHighlightingPass = */ false
        )
    }
}

class PyPasHighlightingPassFactory : TextEditorHighlightingPassFactory {
    override fun createHighlightingPass(file: PsiFile, editor: Editor): TextEditorHighlightingPass? {
        if (file !is PyPasFile) return null
        return PyPasAfterResolveHighlightingPass(file, editor.document)
    }

}

class PyPasAfterResolveHighlightingPass(file: PyPasFile, document: Document) : TextEditorHighlightingPass(file.project, document) {
    override fun doCollectInformation(progress: ProgressIndicator) {
        TODO("Not yet implemented")
    }

    override fun doApplyInformationToEditor() {
        TODO("Not yet implemented")
    }

}
