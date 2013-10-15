string-metric
=============

A Java library of [String metrics](http://en.wikipedia.org/wiki/String_metric).

## [Damerau-Levenshtein distance](http://en.wikipedia.org/wiki/Damerau%E2%80%93Levenshtein_distance)

```
import edu.gatech.gtri.stringmetric.*;
```

```
StringMetric metric = new DamerauLevenshteinDistance();

assert(4 == metric.distance(
        "The quick brown fox jumps over the lazy dog.",
        "Thy quick brown ox jumps hover teh lazy dog."));
//         |             |        |      ||
//         |             |        |      \|
//   Substitution        |    Insertion   |
//                       |                |
//                   Deletion        Transposition of two
//                                   adjacent characters
```

## Release artifacts

This project's release artifacts are available in the Maven
[Central Repository](http://search.maven.org/#search%7Cga%7C1%7Cedu.gatech.gtri.string-metric).

```
<dependency>
  <groupId>edu.gatech.gtri.string-metric</groupId>
  <artifactId>string-metric</artifactId>
  <version>1.0</version>
</dependency>
```
