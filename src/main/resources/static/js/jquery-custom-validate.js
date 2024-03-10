jQuery.validator.addMethod('usernameMatched', (value, element) => {
  console.log(value)
  console.log(element)
}, '이미 사용중인 아이디입니다.')
jQuery.validator.addMethod('korean', (value, element) => {
  const regexp = new RegExp('^[가-힣]+$')
  return regexp.test(value)
}, '한글만 입력 가능합니다.')