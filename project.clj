(defproject io.gamayun/proto2spec "0.1.0-SNAPSHOT"
  :description "A Clojure Spec generator for Google Protocol Buffers."
  :url "https://github.com/jvia/proto2spec"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [metosin/spec-tools "0.7.0"]
                 [clojusc/protobuf "3.5.1-v1.1"]]
  
  :prep-tasks [["shell" "mkdir" "-p" "target/examples"]
               ["shell" "protoc" "-I=/usr/include" "-I=/usr/local/include" "-I=resources" "--java_out=target/examples" "resources/protobuf/examples/photo.proto"]
               ["javac"]]

  :plugins [[lein-shell "0.5.0"]]

  :profiles {:dev {:source-paths ["dev"]
                   :dependencies [[org.clojure/test.check "0.9.0"]]}
             :test {:resource-paths ["test-resources"]
                    :java-source-paths ["target/examples"]}})
