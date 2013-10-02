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

import java.util.HashMap;
import java.util.Map;

import static java.lang.Math.max;

/**
 * The <a href="http://en.wikipedia.org/wiki/Damerau%E2%80%93Levenshtein_distance">Damerau-Levenshtein distance</a>
 * string metric.
 */
public class DamerauLevenshteinDistance implements StringMetric {

    @Override
    public int distance(CharSequence s, CharSequence t) {
        int m = s.length();
        int n = t.length();

        if (m == 0) {
            return n;
        }
        if (n == 0) {
            return m;
        }

        int inf = max(m, n);
        int[][] h = new int[m + 2][n + 2];
        h[0][0] = inf;
        for (int i = 0; i <= m; ++i) {
            h[i + 1][1] = i;
            h[i + 1][0] = inf;
        }
        for (int j = 0; j <= n; ++j) {
            h[1][j + 1] = j;
            h[0][j + 1] = inf;
        }

        Map<Character, Integer> da = new HashMap<Character, Integer>(128);
        for (int i = 0; i < m; ++i) {
            da.put(s.charAt(i), 0);
        }
        for (int j = 0; j < n; ++j) {
            da.put(t.charAt(j), 0);
        }

        for (int i = 1; i <= m; ++i) {
            int db = 0;
            for (int j = 1; j <= n; ++j) {
                int i1 = da.get(t.charAt(j - 1));
                int j1 = db;

                int d = s.charAt(i - 1) == t.charAt(j - 1) ? 0 : 1;
                if (d == 0) db = j;

                h[i + 1][j + 1] = min(
                    h[i][j] + d,
                    h[i + 1][j] + 1,
                    h[i][j + 1] + 1,
                    h[i1][j1] + (i - i1 - 1) + 1 + (j - j1 - 1)
                );
            }
            da.put(s.charAt(i - 1), i);
        }

        return h[m + 1][n + 1];
    }

    private int min(int a, int b, int c, int d) {
        return Math.min(a, Math.min(b, Math.min(c, d)));
    }
}
