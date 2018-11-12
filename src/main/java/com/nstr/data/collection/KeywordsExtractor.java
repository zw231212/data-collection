package com.nstr.data.collection;

import com.nstr.data.collection.model.TagField;

import java.util.List;

public interface KeywordsExtractor {

    List<TagField> extract(String content);

}
