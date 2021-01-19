install.packages("arules")
install.packages("arulesViz")
library(arules)
library(arulesViz)

Groceries<-read.csv("Groceries.csv")

data(Groceries)

inspect(Groceries[1:10])

itemFrequencyPlot(Groceries,topN=10,type="absolute")

itemsets<-apriori(Groceries,parameter=list(minlen=1,maxlen=10,sup=0.02,target="frequent itemsets"))
inspect(sort(itemsets,by="support"))

itemrules<-apriori(Groceries,parameter=list(minlen=1,maxlen=10,sup=0.02,conf=0.4,target="rules"))
inspect(itemrules,by="confidence")

plot(itemrules,method="graph")