var str = '안녕00방가00좋은아침00좋은하루'; // 모든 00 -> x 변경
console.log('원본 str : ' + str );
var splitStr = str.split('00'); // ['안녕', '방가', '좋은아침', '좋은하루']
console.log('분할된 str : ' + splitStr);
var joinStr = splitStr.join('x');
console.log('join된 str : ' + joinStr);

function replaceAll(str, oldSrt, newStr) {
    // let splitStr = str.split(oldSrt);
    // let result = splitStr.join(newStr);
    // return result;
    return str.split(oldSrt).join(newStr);  // 위 세 문장을 하나로 합쳤다
}
var replaceStr = replaceAll('안녕00방가00좋은아침00좋은하루', '00', 'x');
console.log('결과 : ' + replaceStr);