#!/bin/bash
rm -rf classes Compiled && mkdir Compiled classes

java -cp clojure.jar:Leikr-0.0.12.jar:src/  clojure.main -e "(compile 'MyClojure)"

mv classes/* Compiled/
