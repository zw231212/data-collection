package com.nstr.data.collection.util;

import com.nstr.data.collection.model.TagField;
import org.ansj.app.keyword.KeyWordComputer;
import org.ansj.app.keyword.Keyword;

import java.util.ArrayList;
import java.util.List;

public class KeywordsUtil {

    private static KeyWordComputer kwc = new KeyWordComputer(8);

    /**
     * 提取关键词的工具类
     * @param content
     * @return
     */
    public static List<TagField> keywords(String content){
        if(StringUtil.isNullOrBlank(content)){
            return null;
        }

        List<Keyword> list = kwc.computeArticleTfidf(content);
        if(list == null || list.size() == 0){
            return null;
        }
        List<TagField> tags = new ArrayList<>();
        for (Keyword keyword : list) {
            tags.add(new TagField(keyword.getName(), keyword.getFreq()));
        }
        return tags;
    }

    public static List<Keyword> keywords2(String content){
        if(StringUtil.isNullOrBlank(content)){
            return null;
        }
        List<Keyword> list = kwc.computeArticleTfidf(content);
        return list;
    }

}
