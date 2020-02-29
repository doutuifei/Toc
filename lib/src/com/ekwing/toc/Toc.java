package com.ekwing.toc;

import com.github.houbb.markdown.toc.core.impl.AtxMarkdownToc;
import com.github.houbb.markdown.toc.vo.TocGen;

public class Toc {

    public static void main(String[] args) {
        if (args == null || args.length < 1) {
            System.out.println("please input markdown file path");
            return;
        }
        String path = args[0];
//        String path = "E:\\GradleProjects\\TocPlugin\\res\\test.md";
        TocGen tocGen = AtxMarkdownToc.newInstance().genTocFile(path);
        if (tocGen != null) {
            System.out.println("create toc success!!!");
        } else {
            System.out.println("create toc failed!!!");
        }
    }

}
