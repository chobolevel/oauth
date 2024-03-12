jQuery.validator.addMethod('korean', (value, element) => {
  const regexp = new RegExp('^[가-힣]+$')
  return regexp.test(value)
}, '한글만 입력 가능합니다.')