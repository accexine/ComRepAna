data = read.table("D:\\score_results.txt", 
           sep="\t", 
           col.names=c("source", "id", "mid", "date", "score"), 
           fill=TRUE, 
           strip.white=TRUE)
x = 1
mid=0
mid_list=c()
for(i in 1:length(data$source)){
  if(mid != data[i,3]){
    mid = data[i,3]
    mid_list[x] = mid
    x = x+1
  }
}
for(i in 1:length(mid_list)){
  mid = mid_list[i]
  temp = data[data$mid==mid,]
  temp = temp[ order(temp$date), ]
  drawgraph(temp,mid)
}

setwd("D:\\graph\\")

drawgraph<-function(datas,name){
  png(file=paste(name,'.png',sep=""));
  plot(datas$score,type="l",xlab=mid,ylab="")
  dev.off()
}