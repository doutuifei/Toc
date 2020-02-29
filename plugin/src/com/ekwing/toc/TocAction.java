package com.ekwing.toc;

import com.github.houbb.markdown.toc.core.impl.AtxMarkdownToc;
import com.github.houbb.markdown.toc.vo.TocGen;
import com.intellij.ide.actions.RefreshAction;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.ui.Messages;
import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.NotNull;

public class TocAction extends AnAction {

    @Override
    public void update(@NotNull AnActionEvent e) {
        super.update(e);
        VirtualFile virtualFile = e.getData(PlatformDataKeys.VIRTUAL_FILE);
        if (virtualFile == null) {
            e.getPresentation().setEnabled(false);
            return;
        }
        String fileTypeName = virtualFile.getFileType().getName();
        System.out.println(fileTypeName);
        if (!"Markdown".equals(fileTypeName)) {
            e.getPresentation().setEnabled(false);
            return;
        }
        e.getPresentation().setEnabled(true);
    }

    @Override
    public void actionPerformed(AnActionEvent e) {
        VirtualFile virtualFile = e.getData(PlatformDataKeys.VIRTUAL_FILE);
        TocGen tocGen = AtxMarkdownToc.newInstance().genTocFile(virtualFile.getPath());
        if (tocGen != null) {
            virtualFile.refresh(false,false);
            Messages.showMessageDialog("创建Toc成功", "提醒", Messages.getInformationIcon());
        } else {
            Messages.showMessageDialog("创建Toc失败", "提醒", Messages.getInformationIcon());
        }
    }

}
