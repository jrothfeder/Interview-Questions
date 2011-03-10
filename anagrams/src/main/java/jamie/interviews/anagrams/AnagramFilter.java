/**
 * Copyright (C) 2011 Brightcove Inc. All Rights Reserved. No use, copying or distribution of this
 * work may be made except in accordance with a valid license agreement from Brightcove Inc. This
 * notice must be included on all copies, modifications and derivatives of this work.
 * 
 * Brightcove Inc MAKES NO REPRESENTATIONS OR WARRANTIES ABOUT THE SUITABILITY OF THE SOFTWARE,
 * EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE IMPLIED WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE, OR NON-INFRINGEMENT. BRIGHTCOVE SHALL NOT BE
 * LIABLE FOR ANY DAMAGES SUFFERED BY LICENSEE AS A RESULT OF USING, MODIFYING OR DISTRIBUTING THIS
 * SOFTWARE OR ITS DERIVATIVES.
 * 
 * "Brightcove" is a registered trademark of Brightcove Inc.
 */
package jamie.interviews.anagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AnagramFilter {

    public List<String> filter(List<String> potentialAnagrams) {
        if(potentialAnagrams == null) {
            return Collections.emptyList();
        }
        
        Map<String,String> buffer = new HashMap<String,String>();
        Set<String> anagrams = new HashSet<String>();

        for(String potentialAnagram : potentialAnagrams) {
            char[] chars = potentialAnagram.toCharArray();
            Arrays.sort(chars);
            String hash = new String(chars);
            if(buffer.containsKey(hash)) {
                anagrams.add(potentialAnagram);
                anagrams.add(buffer.get(hash));
            } 
            buffer.put(hash, potentialAnagram);
        }
        return new ArrayList<String>(anagrams);
    }
}
