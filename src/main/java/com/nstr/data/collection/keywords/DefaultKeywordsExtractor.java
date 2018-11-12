package com.nstr.data.collection.keywords;

import com.nstr.data.collection.KeywordsExtractor;
import com.nstr.data.collection.model.TagField;
import com.nstr.data.collection.util.KeywordsUtil;

import java.util.List;

public class DefaultKeywordsExtractor implements KeywordsExtractor {
    @Override
    public List<TagField> extract(String content) {
        return KeywordsUtil.keywords(content);
    }
}
