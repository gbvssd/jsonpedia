/*
 * Copyright 2012-2015 Michele Mostarda (me@michelemostarda.it)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.machinelinking.extractor;

import com.machinelinking.pagestruct.Ontology;
import com.machinelinking.serializer.Serializable;
import com.machinelinking.serializer.Serializer;

/**
 * Defines a <i>Wikipedia section</i>.
 *
 * @author Michele Mostarda (me@michelemostarda.it)
 */
public class Section implements Serializable {

    private final String title;
    private final int level;
    private final int[] ancestors;

    public Section(String title, int[] ancestors, int level) {
        this.title = title;
        this.level = level;
        this.ancestors = ancestors;
    }

    public String getTitle() {
        return title;
    }

    public int getLevel() {
        return level;
    }

    @Override
    public void serialize(Serializer serializer) {
        serializer.openObject();
        serializer.fieldValue(Ontology.TITLE_FIELD, title);
        serializer.fieldValue(Ontology.LEVEL_FIELD, level);
        serializer.field(Ontology.ANCESTORS_FIELD);
        serializer.openList();
        for(int i: ancestors){
            serializer.value(i);
        }
        serializer.closeList();
        serializer.closeObject();
    }

}
