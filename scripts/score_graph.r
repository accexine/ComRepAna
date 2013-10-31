setwd("D:\\graph\\")
interval = 60; #时间间隔

drawgraph <- function(matrix,mid){
  png(paste(mid,".png"),width=800,height=800);
  barplot(matrix[1,],col="blue",ylim=c(-1,1),xaxt="n",xlab = paste("Time Series\n",mid), ylab="Score");
  barplot(-matrix[2,],col="red",add=TRUE);
  lines(matrix[3,],col="antiquewhite4",lty=2);
  legend("topright", 
         legend = c("pos.count/total.count", "neg.count/total.count", "average"), 
         fill = c("blue", "red", "antiquewhite4"),
         bty = "n",
         cex = 1);
  dev.off();
  print(mid);
}

getmatrix <- function(subset){
  subset = subset[order(subset$date),];
  subset$date = as.POSIXlt(subset$date);
  begin.date = min(subset$date);
  end.date = begin.date + interval * 60;
  counts.support = matrix(nrow = 3, ncol = 0);
  counts.names = c();
  max.date = max(subset$date);
  
#  list.score = c();
#  for(i in 1:length(subset$id)){
#    if(subset[i,]$date < end.date){
#      list.score[length(list.score)+1] = subset[i,]$score; 
#    }else{
#      if(length(list.score > 0)){
#         counts = computecount(list.score);
#         counts.support = cbind(counts.support,counts);
#         counts.names[length(counts.names)+1] = begin.date;
#         list.score = c();
#         begin.date = end.date;
#         end.data = end.date + interval * 60;
#      }
#    }
# }
  while(end.date <= max.date){
    subset.subset = subset[begin.date <= subset$date,];
    subset.subset = subset.subset[subset.subset$date < end.date,];
    if(length(subset.subset$id) > 0){
      counts = computecount(subset.subset$score);
      counts.support = cbind(counts.support,"test"=counts);
      counts.names[length(counts.names)+1] = paste(begin.date);
   }
    begin.date = end.date;
    end.date = end.date + interval * 60;
  }
  colnames(counts.support) = counts.names;
  rownames(counts.support) = c("pos.count/total count","neg.count/total count","average");
  return (counts.support);
}

computecount <- function(score.list){
  counts = c(0,0,0); #c[1] is positive, c[2] is negative, c[3] is average
  for(i in score.list){
    if(i > 0) counts[1] = counts[1] + 1;
    if(i < 0) counts[2] = counts[2] + 1;
  }
  counts[1] = counts[1]/length(score.list);
  counts[2] = counts[2]/length(score.list);
  counts[3] = mean(score.list);
  return (counts);
}





data = read.table("D:\\score_results.txt", 
           sep="\t", 
           col.names=c("source", "id", "mid", "date", "score"), 
           fill=TRUE, 
           strip.white=TRUE);
data$score = as.double(data$score);
mid.list = unique(data$mid); #set all mid into mid.list
for(i in mid.list){
  data.subset = data[data$mid == i,];
  matrix.counts = getmatrix(data.subset);
  drawgraph(matrix.counts,i);
}