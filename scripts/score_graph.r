comments = read.table("D:\\comments_score_results.txt", 
                     sep=",", 
                     col.names=c("id", "mid", "date", "score"), 
                     fill=FALSE, 
                     strip.white=TRUE)
reposts = read.table("D:\\reposts_score_results.txt",
                     sep=",", 
                     col.names=c("id", "mid", "date", "score"), 
                     fill=FALSE, 
                     strip.white=TRUE)

comments = comments[ order(comments[,3]), ]
reposts = reposts[ order(reposts[,3]), ]
par(mfrow=c(1,2)) 
plot(comments[,4],type='l',xlab="comments",ylab="")
plot(reposts[,4],type='l',xlab="reposts",ylab="")