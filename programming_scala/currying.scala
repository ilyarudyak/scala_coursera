def cat(s1: String)(s2: String) = s1 + s2
println(cat("hello ")("my friend"))

def cat1(s1: String) = (s2: String) => s1 + s2
println(cat1("hello ")("my friend"))

def cat2 = cat("hello ") _
println(cat2("my friend"))

def multiplier(i: Int)(factor: Int) = i * factor 
val byFive = multiplier(5) _
val byTen = multiplier(10) _

println(byFive(5))
println(byFive(10))
