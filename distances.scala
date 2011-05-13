
/** 
 * Creates borders between list Elements
 */
def borders[T](l: List[T]): IndexedSeq[(T, T)] = {
  for (i <- 1.to(l.length-1); j <- 0.to(l.length); k = j+i if k < l.length) yield (l(j) -> l(k))
}

