/*
 * Copyright 2013 Georgia Tech Applied Research Corporation
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

package edu.gatech.gtri.stringmetric;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class DamerauLevenshteinDistanceTest {
    @Test
    public void testDistance() throws Exception {
        DamerauLevenshteinDistance metric = new DamerauLevenshteinDistance();

        assertEquals(metric.distance("", ""), 0);

        assertEquals(metric.distance("a", ""), 1);
        assertEquals(metric.distance("", "a"), 1);

        assertEquals(metric.distance("a", "c"), 1);
        assertEquals(metric.distance("c", "a"), 1);

        assertEquals(metric.distance("abc", "bac"), 1);
        assertEquals(metric.distance("bac", "abc"), 1);

        assertEquals(metric.distance("ca", "abc"), 2);
        assertEquals(metric.distance("abc", "ca"), 2);

        assertEquals(metric.distance("abcdef", "hijklm"), 6);
        assertEquals(metric.distance("hijklm", "abcdef"), 6);

        assertEquals(metric.distance("book", ""), 4);
        assertEquals(metric.distance("", "book"), 4);

        assertEquals(metric.distance("book", "book"), 0);

        assertEquals(metric.distance("book", "books"), 1);
        assertEquals(metric.distance("books", "book"), 1);

        assertEquals(metric.distance("book", "bookies"), 3);
        assertEquals(metric.distance("bookies", "book"), 3);

        assertEquals(metric.distance("book", "nook"), 1);
        assertEquals(metric.distance("nook", "book"), 1);

        assertEquals(metric.distance("book", "obok"), 1);
        assertEquals(metric.distance("obok", "book"), 1);

        assertEquals(metric.distance("book", "blok"), 1);
        assertEquals(metric.distance("blok", "book"), 1);

        assertEquals(metric.distance("book", "blop"), 2);
        assertEquals(metric.distance("blop", "book"), 2);

        assertEquals(metric.distance("book", "blpo"), 3);
        assertEquals(metric.distance("blpo", "book"), 3);

        assertEquals(metric.distance("book", "bok"), 1);
        assertEquals(metric.distance("bok", "book"), 1);

        assertEquals(metric.distance("book", "nok"), 2);
        assertEquals(metric.distance("nok", "book"), 2);

        assertEquals(metric.distance("book", "nko"), 3);
        assertEquals(metric.distance("nko", "book"), 3);

        assertEquals(metric.distance("boik", "ikob"), 4);
        assertEquals(metric.distance("ikob", "boik"), 4);

        assertEquals(metric.distance("wikipedia", "wikiepdia"), 1);
        assertEquals(metric.distance("wikiepdia", "wikipedia"), 1);

        assertEquals(metric.distance("amplify", "ilapfym"), 6);
        assertEquals(metric.distance("ilapfym", "amplify"), 6);

        assertEquals(metric.distance("amplify", "palymfi"), 5);
        assertEquals(metric.distance("palymfi", "amplify"), 5);

        assertEquals(metric.distance("upstream", "aeumsrtp"), 7);
        assertEquals(metric.distance("aeumsrtp", "upstream"), 7);

        assertEquals(metric.distance("upstream", "aeumsrtp"), 7);
        assertEquals(metric.distance("aeumsrtp", "upstream"), 7);

        assertEquals(metric.distance("flank", "lfank"), 1);
        assertEquals(metric.distance("lfank", "flank"), 1);

        assertEquals(metric.distance("flank", "lfaok"), 2);
        assertEquals(metric.distance("lfaok", "flank"), 2);

        assertEquals(metric.distance("flank", "lfok"), 3);
        assertEquals(metric.distance("lfok", "flank"), 3);

        assertEquals(metric.distance("flank", "lfko"), 4);
        assertEquals(metric.distance("lfko", "flank"), 4);
    }
}
