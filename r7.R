install.packages("factoextra")
library(factoextra)

data<-iris
data$Species<-NULL

distance1<-scale(dist(data,method="euclidian"))
kmodel<-kmeans(distance1,3)

fviz_cluster(kmodel,data,geom="point")

distance2<-dist(data[,3:4],method="euclidian")
hmodel<-hclust(distance2,method="average")

plot(hmodel)