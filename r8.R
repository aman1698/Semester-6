install.packages("fpc")
data(iris)
str(iris)

library(fpc)

iris_1<-iris[-5]

set.seed(220)

Dbscan_c1<-dbscan(iris_1,eps=0.45,MinPts=5)
Dbscan_c1

Dbscan_c1$cluster

table(Dbscan_c1$cluster, iris_1$Species)

plot(Dbscan_c1,iris_1,main="DBScan")
plot(Dbscan_c1,iris_1,main="Sepal Length vs Petal Length")