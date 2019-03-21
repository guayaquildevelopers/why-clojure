(import '[net.openhft.hashing LongHashFunction])

(defn xxhash
  [s]
  (format "%x" (.hashChars (LongHashFunction/xx) s)))

(println (xxhash "Hola Guayaquil Developers!"))
; edcd8d2f7d004b23