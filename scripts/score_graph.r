#setwd("D:\\graph\\")
interval = 10; #时间间隔


drawgraph <- function(datas,name){
  datas$date = as.POSIXlt(datas$date);
  min_date = min(datas$date);
  max_date = max(datas$data);
  counts.support = matrix(nrow=3,ncol=0);
  begin_date = min_date;
  end_date = min_date + interval * 60;
  while(end_date<=max_date){
    counts = computecount(begin_date,end_date,temp);
    counts.support = cbind(counts.support,mid=counts);
    begin_date = end_date;
    end_date = end_date + interval * 60;
  }
  return (counts.support)
  #  png(file=paste(name,'.png',sep=""));
  #plot(datas$score,type="l",xlab=mid,ylab="")
  #  dev.off()
}

computecount <- function(begin_date, end_date, datas){
  counts = c(0,0,0) #c[1]为正，c[2]为负,c[3]为0.0
  for(i in 1:length(datas$date)){
    if(datas$score[i] > 0.0) counts[1] = counts[1] + 1
    else if(datas$score[i] <0.0) counts[2] = counts[2] +1
    else counts[3] = counts[3] + 1
    if(datas$date[i]>end_data) break;
  }
  return (counts)
}




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