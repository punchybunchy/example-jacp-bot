require: slotfilling/slotFilling.sc
  module = sys.zb-common
theme: /

    state: Start
        q!: $regex</start>
        a: Начнём.
        a: Добро пожаловать!
        intent: /Супер! || toState = "/Hello"
        intent: /Супер || toState = "/Bye"
        intent: /Суперски || toState = "/NoMatch"
        intent: /Отлично || toState = "./"
        event: noMatch || toState = "./"

    state: Hello
        intent!: /привет
        a: Привет привет

    state: Bye
        intent!: /пока
        a: Пока пока

    state: NoMatch
        event!: noMatch
        a: Я не понял. Вы сказали: {{$request.query}}

    state: Match
        event!: match
        a: {{$context.intent.answer}}