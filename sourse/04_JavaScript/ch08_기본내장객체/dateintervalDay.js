// today.getIntervalDay(openday) : today 부터 openday까지 기간의 날짜를 return
// this는 today, that은 openday
// console.log(new Date().getTime());
Date.prototype.getIntervalDay = function (that) {
  if (this > that) {
    var intervalMilliSec = this.getTime() - that.getTime();
  } else {
    var intervalMilliSec = that.getTime() - this.getTime();
  } // this와 that 사이의 밀리컨을 구함
  var day = intervalMilliSec / (1000 * 60 * 60 * 24); // 밀리세컨을 일로 변경
  return Math.trunc(day); // 일 에 소수점 버리기
};
// var openday = new Date(2022, 10, 28, 9, 30, 0); // 개강 시점
// var limitday = new Date(2023, 4, 12, 12, 20, 0); // 수료 시점
// console.log(openday.getIntervalDay(limitday) + '일');
// console.log(new Date().getIntervalDay(limitday) + '일')
