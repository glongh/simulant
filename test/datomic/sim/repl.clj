(ns datomic.sim.repl
  (:require [datomic.api :as d]))

(defn scratch-conn
  "Create a connection to an anonymous, in-memory database."
  []
  (let [uri (str "datomic:mem://" (d/squuid))]
    (d/delete-database uri)
    (d/create-database uri)
    (d/connect uri)))

(defn convenient
  []
  (in-ns 'user)
  (set! *warn-on-reflection* true)
  (set! *print-length* 20)
  (use '[datomic.api :as d])
  (use 'datomic.sim.util)
  (require
   '[clojure.string :as str]
   '[clojure.java.io :as io]
   '[clojure.test.generative.generators :as gen]
   '[clojure.pprint :as pprint]
   '[datomic.sim :as sim]))
