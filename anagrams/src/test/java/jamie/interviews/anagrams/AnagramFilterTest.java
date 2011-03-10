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

import static java.util.Arrays.asList;
import static java.util.Collections.sort;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;


public class AnagramFilterTest {
    AnagramFilter filter = new AnagramFilter();
    
    @Test
    public void testFilter_WithAnagrams() {
        testHelper(new String[] {"cat","tac","army","pam","act","map","kid"}, 
                   new String[] {"act", "cat", "map", "pam", "tac"});
    }
    
    @Test
    public void testFilter_NoAanagrams() {
        testHelper(new String[] {"boy", "door", "army", "fish"},new String[] {});
    }
    
    @Test
    public void testFilter_NullInput() {
        testHelper(null, new String[] {});
    }
    
    @Test
    public void testFilter_EmptyInput() {
        testHelper(new String[] {}, new String[] {});
    }
    
    private void testHelper(String[] input, String[] expectedOutput) {
        
        List<String> actualOutput = filter.filter(input == null ? null : asList(input));
        sort(actualOutput);
        
        assertArrayEquals(expectedOutput, actualOutput.toArray()); 
    }
   
}
