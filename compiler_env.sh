#!/bin/bash
string='/home/minhkhoa/project_2nd_hd/cross/java/kotlin/junit4Selenium/tool/kotlinCompiler/kotlinc/bin'
if [[ $string == *"$PATH"* ]]; then
  echo kotlin compiler is in PATH already
  exit
fi
PATH="$PATH:/home/minhkhoa/project_2nd_hd/cross/java/kotlin/junit4Selenium/tool/kotlinCompiler/kotlinc/bin:/home/minhkhoa/project_2nd_hd/cross/java/kotlin/junit4Selenium/tool/chromedriver"
echo $PATH
export PATH
bash
