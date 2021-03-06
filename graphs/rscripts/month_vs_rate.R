#!/usr/bin/env Rscript
# month vs hitrate
rates <- read.csv("ratesfile", comment.char="#")
attach(rates)
plot(Week, HitRate, type="p", ylim=range(0,100), xlim=range(1,max(Week)), xaxt="n")
axis(at=Month, side=1)
abline(h=max(HitRate), lty=2)
abline(h=min(HitRate), lty=2)
mtext(side=4, text=min(HitRate), las=1, at=min(HitRate))
mtext(side=4, text=max(HitRate), las=1, at=max(HitRate))
# To add extra info: 
 par(new=T)
 plot(Week, NumAdds, type="p", axes=F, pch=3, xlab="", ylab="", xlim=range(1,max(Week)))
 legend(max(Month) - 50, 1500, legend=c("NumHits","NumAdds"), pch=c(1,3))
#  par(new=T)
# plot(Month, NumCommits, type="p", axes=F, pch=3, xlab="", ylab="", xlim=range(1,max(Month)))
# legend(max(Month) -60, 200, legend=c("NumHits","NumCommits"), pch=c(1,3))
