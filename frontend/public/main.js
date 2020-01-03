!function(e){function n(n){for(var r,c,a=n[0],u=n[1],g=n[2],C=0,b=[];C<a.length;C++)c=a[C],Object.prototype.hasOwnProperty.call(l,c)&&l[c]&&b.push(l[c][0]),l[c]=0;for(r in u)Object.prototype.hasOwnProperty.call(u,r)&&(e[r]=u[r]);for(I&&I(n);b.length;)b.shift()();return o.push.apply(o,g||[]),t()}function t(){for(var e,n=0;n<o.length;n++){for(var t=o[n],r=!0,a=1;a<t.length;a++){var u=t[a];0!==l[u]&&(r=!1)}r&&(o.splice(n--,1),e=c(c.s=t[0]))}return e}var r={},l={0:0},o=[];function c(n){if(r[n])return r[n].exports;var t=r[n]={i:n,l:!1,exports:{}};return e[n].call(t.exports,t,t.exports,c),t.l=!0,t.exports}c.m=e,c.c=r,c.d=function(e,n,t){c.o(e,n)||Object.defineProperty(e,n,{enumerable:!0,get:t})},c.r=function(e){"undefined"!=typeof Symbol&&Symbol.toStringTag&&Object.defineProperty(e,Symbol.toStringTag,{value:"Module"}),Object.defineProperty(e,"__esModule",{value:!0})},c.t=function(e,n){if(1&n&&(e=c(e)),8&n)return e;if(4&n&&"object"==typeof e&&e&&e.__esModule)return e;var t=Object.create(null);if(c.r(t),Object.defineProperty(t,"default",{enumerable:!0,value:e}),2&n&&"string"!=typeof e)for(var r in e)c.d(t,r,function(n){return e[n]}.bind(null,r));return t},c.n=function(e){var n=e&&e.__esModule?function(){return e.default}:function(){return e};return c.d(n,"a",n),n},c.o=function(e,n){return Object.prototype.hasOwnProperty.call(e,n)},c.p="";var a=window.webpackJsonp=window.webpackJsonp||[],u=a.push.bind(a);a.push=n,a=a.slice();for(var g=0;g<a.length;g++)n(a[g]);var I=u;o.push([50,1]),t()}({50:function(module,__webpack_exports__,__webpack_require__){"use strict";eval('__webpack_require__.r(__webpack_exports__);\n\n// EXTERNAL MODULE: ./node_modules/regenerator-runtime/runtime.js\nvar runtime = __webpack_require__(22);\n\n// EXTERNAL MODULE: ./node_modules/react/index.js\nvar react = __webpack_require__(0);\nvar react_default = /*#__PURE__*/__webpack_require__.n(react);\n\n// EXTERNAL MODULE: ./node_modules/react-dom/index.js\nvar react_dom = __webpack_require__(6);\n\n// EXTERNAL MODULE: ./node_modules/react-redux/es/index.js + 24 modules\nvar es = __webpack_require__(4);\n\n// CONCATENATED MODULE: ./src/constants.js\nvar ADD_EMPLOYEE = \'ADD_EMPLOYEE\';\nvar UDATE_EMPLOYEE = \'UPDATE_EMPLOYEE\';\n// CONCATENATED MODULE: ./src/actions/index.js\n\nvar nextEmployeeId = 1;\nvar nextSalaryId = 1;\nvar actions_addEmployee = function addEmployee(name, amount) {\n  return {\n    type: ADD_EMPLOYEE,\n    id: ++nextEmployeeId,\n    name: name,\n    salary: {\n      id: ++nextSalaryId,\n      currency: \'RUR\',\n      amount: amount\n    }\n  };\n};\nvar actions_updateEmployee = function updateEmployee(employee) {\n  return {\n    type: UDATE_EMPLOYEE,\n    employee: employee\n  };\n};\n// CONCATENATED MODULE: ./src/components/EmployeeRow.js\nfunction _typeof(obj) { if (typeof Symbol === "function" && typeof Symbol.iterator === "symbol") { _typeof = function _typeof(obj) { return typeof obj; }; } else { _typeof = function _typeof(obj) { return obj && typeof Symbol === "function" && obj.constructor === Symbol && obj !== Symbol.prototype ? "symbol" : typeof obj; }; } return _typeof(obj); }\n\nfunction _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }\n\nfunction _defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } }\n\nfunction _createClass(Constructor, protoProps, staticProps) { if (protoProps) _defineProperties(Constructor.prototype, protoProps); if (staticProps) _defineProperties(Constructor, staticProps); return Constructor; }\n\nfunction _possibleConstructorReturn(self, call) { if (call && (_typeof(call) === "object" || typeof call === "function")) { return call; } return _assertThisInitialized(self); }\n\nfunction _getPrototypeOf(o) { _getPrototypeOf = Object.setPrototypeOf ? Object.getPrototypeOf : function _getPrototypeOf(o) { return o.__proto__ || Object.getPrototypeOf(o); }; return _getPrototypeOf(o); }\n\nfunction _assertThisInitialized(self) { if (self === void 0) { throw new ReferenceError("this hasn\'t been initialised - super() hasn\'t been called"); } return self; }\n\nfunction _inherits(subClass, superClass) { if (typeof superClass !== "function" && superClass !== null) { throw new TypeError("Super expression must either be null or a function"); } subClass.prototype = Object.create(superClass && superClass.prototype, { constructor: { value: subClass, writable: true, configurable: true } }); if (superClass) _setPrototypeOf(subClass, superClass); }\n\nfunction _setPrototypeOf(o, p) { _setPrototypeOf = Object.setPrototypeOf || function _setPrototypeOf(o, p) { o.__proto__ = p; return o; }; return _setPrototypeOf(o, p); }\n\n\n\n\n/**\n * Строка таблицы Сотрудники.\n */\n\nvar EmployeeRow_EmployeeRow =\n/*#__PURE__*/\nfunction (_Component) {\n  _inherits(EmployeeRow, _Component);\n\n  function EmployeeRow(props) {\n    var _this;\n\n    _classCallCheck(this, EmployeeRow);\n\n    _this = _possibleConstructorReturn(this, _getPrototypeOf(EmployeeRow).call(this, props));\n    _this.state = {\n      employee: _this.props.employee\n    };\n    _this.onAmountChange = _this.onAmountChange.bind(_assertThisInitialized(_this));\n    _this.onSubmit = _this.onSubmit.bind(_assertThisInitialized(_this));\n    return _this;\n  }\n\n  _createClass(EmployeeRow, [{\n    key: "onAmountChange",\n    value: function onAmountChange(evt) {\n      evt.preventDefault();\n      var value = evt.target.value;\n      var tmp = this.state.employee;\n      tmp.salary.amount = value;\n      this.setState({\n        employee: tmp\n      });\n    }\n  }, {\n    key: "onSubmit",\n    value: function onSubmit(evt) {\n      evt.preventDefault();\n      var employee = this.state.employee;\n      this.props.updateEmployee(employee);\n    }\n  }, {\n    key: "render",\n    value: function render() {\n      var employee = this.state.employee;\n      return react_default.a.createElement("tr", null, react_default.a.createElement("td", null, employee.name), react_default.a.createElement("td", null, react_default.a.createElement("input", {\n        value: employee.salary.amount,\n        onChange: this.onAmountChange\n      })), react_default.a.createElement("td", null, react_default.a.createElement("button", {\n        onClick: this.onSubmit\n      }, "\\u0421\\u043E\\u0445\\u0440\\u0430\\u043D\\u0438\\u0442\\u044C")));\n    }\n  }]);\n\n  return EmployeeRow;\n}(react["Component"]);\n\nvar EmployeeRow_mapDispatchToProps = function mapDispatchToProps(dispatch) {\n  return {\n    updateEmployee: function updateEmployee(employee) {\n      return dispatch(actions_updateEmployee(employee));\n    }\n  };\n};\n\n/* harmony default export */ var components_EmployeeRow = (Object(es["b" /* connect */])(null, EmployeeRow_mapDispatchToProps)(EmployeeRow_EmployeeRow));\n// CONCATENATED MODULE: ./src/api/index.js\nfunction asyncGeneratorStep(gen, resolve, reject, _next, _throw, key, arg) { try { var info = gen[key](arg); var value = info.value; } catch (error) { reject(error); return; } if (info.done) { resolve(value); } else { Promise.resolve(value).then(_next, _throw); } }\n\nfunction _asyncToGenerator(fn) { return function () { var self = this, args = arguments; return new Promise(function (resolve, reject) { var gen = fn.apply(self, args); function _next(value) { asyncGeneratorStep(gen, resolve, reject, _next, _throw, "next", value); } function _throw(err) { asyncGeneratorStep(gen, resolve, reject, _next, _throw, "throw", err); } _next(undefined); }); }; }\n\nvar axios = __webpack_require__(32)["default"];\n\nvar BACKEND_URL = \'http://localhost:8080\';\nvar BASE_URL = "".concat( false ? undefined : window.location.origin);\nfunction getAll() {\n  return _getAll.apply(this, arguments);\n}\n\nfunction _getAll() {\n  _getAll = _asyncToGenerator(\n  /*#__PURE__*/\n  regeneratorRuntime.mark(function _callee() {\n    return regeneratorRuntime.wrap(function _callee$(_context) {\n      while (1) {\n        switch (_context.prev = _context.next) {\n          case 0:\n            return _context.abrupt("return", axios.get(BASE_URL + "/employees").then(function (resp) {\n              console.log(resp.data);\n            }));\n\n          case 1:\n          case "end":\n            return _context.stop();\n        }\n      }\n    }, _callee);\n  }));\n  return _getAll.apply(this, arguments);\n}\n// CONCATENATED MODULE: ./src/components/EmployeeTable.js\n\n\n\n\n/**\n * Таблица Сотркдники.\n */\n\nvar EmployeeTable_TableHeader = function TableHeader() {\n  return react_default.a.createElement("thead", null, react_default.a.createElement("tr", null, react_default.a.createElement("th", null, "\\u0421\\u043E\\u0442\\u0440\\u0443\\u0434\\u043D\\u0438\\u043A"), react_default.a.createElement("th", null, "\\u041E\\u043A\\u043B\\u0430\\u0434"), react_default.a.createElement("th", null)));\n};\n\nvar EmployeeTable_EmployeeTable = function EmployeeTable(props) {\n  var employees = props.employees;\n  console.log(getAll());\n  return react_default.a.createElement("table", null, react_default.a.createElement(EmployeeTable_TableHeader, null), react_default.a.createElement("tbody", null, employees.map(function (employee, index) {\n    return react_default.a.createElement(components_EmployeeRow, {\n      key: index,\n      employee: employee\n    });\n  })));\n};\n\nvar mapStateToProps = function mapStateToProps(state) {\n  return {\n    employees: state.employees\n  };\n};\n\n/* harmony default export */ var components_EmployeeTable = (Object(es["b" /* connect */])(mapStateToProps)(EmployeeTable_EmployeeTable));\n// CONCATENATED MODULE: ./src/components/AddEmployee.js\n\n\n\n/**\n * Добавить Сотрудника.\n */\n\nvar AddEmployee_AddEmployee = function AddEmployee(_ref) {\n  var dispatch = _ref.dispatch;\n  var nameInput, amountInput;\n  return react_default.a.createElement("div", null, react_default.a.createElement("form", {\n    id: \'add-employee\',\n    onSubmit: function onSubmit(evt) {\n      evt.preventDefault();\n\n      if (!(\'\' + nameInput.value).trim() || !(\'\' + amountInput.value).trim()) {\n        return;\n      }\n\n      dispatch(actions_addEmployee(nameInput.value, amountInput.value));\n      nameInput.value = \'\';\n      amountInput.value = \'\';\n    }\n  }, react_default.a.createElement("label", null, "\\u0418\\u043C\\u044F:"), react_default.a.createElement("input", {\n    id: \'add-employee-name\',\n    ref: function ref(node) {\n      nameInput = node;\n    }\n  }), react_default.a.createElement("label", null, "\\u041E\\u043A\\u043B\\u0430\\u0434:"), react_default.a.createElement("input", {\n    id: \'add-employee-amount\',\n    ref: function ref(node) {\n      amountInput = node;\n    }\n  }), react_default.a.createElement("button", {\n    id: \'add-employee-submit\',\n    type: "submit"\n  }, "\\u0421\\u043E\\u0437\\u0434\\u0430\\u0442\\u044C")));\n};\n\n/* harmony default export */ var components_AddEmployee = (Object(es["b" /* connect */])()(AddEmployee_AddEmployee));\n// CONCATENATED MODULE: ./src/App.js\n\n\n\n\nvar App_App = function App() {\n  return react_default.a.createElement("div", null, react_default.a.createElement("h2", null, "Roster"), react_default.a.createElement(components_AddEmployee, null), react_default.a.createElement(components_EmployeeTable, null));\n};\n\n/* harmony default export */ var src_App = (App_App);\n// EXTERNAL MODULE: ./node_modules/redux/es/redux.js\nvar redux = __webpack_require__(3);\n\n// EXTERNAL MODULE: ./node_modules/redux-thunk/es/index.js\nvar redux_thunk_es = __webpack_require__(20);\n\n// EXTERNAL MODULE: ./node_modules/redux-devtools-extension/index.js\nvar redux_devtools_extension = __webpack_require__(21);\n\n// CONCATENATED MODULE: ./src/reducers/index.js\nfunction _toConsumableArray(arr) { return _arrayWithoutHoles(arr) || _iterableToArray(arr) || _nonIterableSpread(); }\n\nfunction _nonIterableSpread() { throw new TypeError("Invalid attempt to spread non-iterable instance"); }\n\nfunction _iterableToArray(iter) { if (Symbol.iterator in Object(iter) || Object.prototype.toString.call(iter) === "[object Arguments]") return Array.from(iter); }\n\nfunction _arrayWithoutHoles(arr) { if (Array.isArray(arr)) { for (var i = 0, arr2 = new Array(arr.length); i < arr.length; i++) { arr2[i] = arr[i]; } return arr2; } }\n\n\n\nvar reducers_initialState = [{\n  id: 1,\n  name: "a",\n  salary: {\n    id: 1,\n    currency: "RUR",\n    amount: "1.23"\n  }\n}];\n\nvar reducers_employees = function employees() {\n  var state = arguments.length > 0 && arguments[0] !== undefined ? arguments[0] : reducers_initialState;\n  var action = arguments.length > 1 ? arguments[1] : undefined;\n\n  switch (action.type) {\n    case ADD_EMPLOYEE:\n      return [].concat(_toConsumableArray(state), [{\n        id: action.id,\n        name: action.name,\n        salary: action.salary\n      }]);\n\n    default:\n      return state;\n  }\n};\n\n/* harmony default export */ var reducers = (Object(redux["combineReducers"])({\n  employees: reducers_employees\n}));\n// CONCATENATED MODULE: ./src/store/index.js\n\n\n\n\n\nfunction configureStore(initialState) {\n  return Object(redux["createStore"])(reducers, initialState, Object(redux_devtools_extension["composeWithDevTools"])(redux["applyMiddleware"].apply(void 0, [redux_thunk_es["a" /* default */]])));\n}\n\n/* harmony default export */ var store = (configureStore);\n// CONCATENATED MODULE: ./src/index.js\n\n\n\n\n\n\nvar src_store = store();\nObject(react_dom["render"])(react_default.a.createElement(es["a" /* Provider */], {\n  store: src_store\n}, react_default.a.createElement(src_App, null)), document.getElementById(\'root\'));//# sourceURL=[module]\n//# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJmaWxlIjoiNTAuanMiLCJzb3VyY2VzIjpbIndlYnBhY2s6Ly8vLi9zcmMvY29uc3RhbnRzLmpzPzVmYjAiLCJ3ZWJwYWNrOi8vLy4vc3JjL2FjdGlvbnMvaW5kZXguanM/ZjQwYiIsIndlYnBhY2s6Ly8vLi9zcmMvY29tcG9uZW50cy9FbXBsb3llZVJvdy5qcz9lNTk1Iiwid2VicGFjazovLy8uL3NyYy9hcGkvaW5kZXguanM/MzY1YyIsIndlYnBhY2s6Ly8vLi9zcmMvY29tcG9uZW50cy9FbXBsb3llZVRhYmxlLmpzPzAyMWUiLCJ3ZWJwYWNrOi8vLy4vc3JjL2NvbXBvbmVudHMvQWRkRW1wbG95ZWUuanM/MmM2NCIsIndlYnBhY2s6Ly8vLi9zcmMvQXBwLmpzP2JlOTQiLCJ3ZWJwYWNrOi8vLy4vc3JjL3JlZHVjZXJzL2luZGV4LmpzPzcyODkiLCJ3ZWJwYWNrOi8vLy4vc3JjL3N0b3JlL2luZGV4LmpzPzQzNjAiLCJ3ZWJwYWNrOi8vLy4vc3JjL2luZGV4LmpzP2I2MzUiXSwic291cmNlc0NvbnRlbnQiOlsiZXhwb3J0IGNvbnN0IEFERF9FTVBMT1lFRSA9ICdBRERfRU1QTE9ZRUUnO1xuZXhwb3J0IGNvbnN0IFVEQVRFX0VNUExPWUVFID0gJ1VQREFURV9FTVBMT1lFRSc7XG4iLCJpbXBvcnQge0FERF9FTVBMT1lFRSwgVURBVEVfRU1QTE9ZRUV9IGZyb20gJy4uL2NvbnN0YW50cyc7XG5cbmxldCBuZXh0RW1wbG95ZWVJZCA9IDE7XG5sZXQgbmV4dFNhbGFyeUlkID0gMTtcblxuZXhwb3J0IGNvbnN0IGFkZEVtcGxveWVlID0gKG5hbWUsIGFtb3VudCkgPT4gKHtcbiAgICB0eXBlOiBBRERfRU1QTE9ZRUUsXG4gICAgaWQ6ICsrbmV4dEVtcGxveWVlSWQsXG4gICAgbmFtZTogbmFtZSxcbiAgICBzYWxhcnk6IHtcbiAgICAgICAgaWQ6ICsrbmV4dFNhbGFyeUlkLFxuICAgICAgICBjdXJyZW5jeTogJ1JVUicsXG4gICAgICAgIGFtb3VudDogYW1vdW50XG4gICAgfVxufSk7XG5cbmV4cG9ydCBjb25zdCB1cGRhdGVFbXBsb3llZSA9IGVtcGxveWVlID0+ICh7XG4gICAgdHlwZTogVURBVEVfRU1QTE9ZRUUsXG4gICAgZW1wbG95ZWVcbn0pO1xuIiwiaW1wb3J0IFJlYWN0LCB7Q29tcG9uZW50fSBmcm9tICdyZWFjdCc7XG5pbXBvcnQge2Nvbm5lY3R9IGZyb20gXCJyZWFjdC1yZWR1eFwiO1xuaW1wb3J0IHt1cGRhdGVFbXBsb3llZX0gZnJvbSBcIi4uL2FjdGlvbnNcIjtcblxuLyoqXG4gKiDQodGC0YDQvtC60LAg0YLQsNCx0LvQuNGG0Ysg0KHQvtGC0YDRg9C00L3QuNC60LguXG4gKi9cbmNsYXNzIEVtcGxveWVlUm93IGV4dGVuZHMgQ29tcG9uZW50IHtcblxuICAgIGNvbnN0cnVjdG9yKHByb3BzKSB7XG4gICAgICAgIHN1cGVyKHByb3BzKTtcbiAgICAgICAgdGhpcy5zdGF0ZSA9IHtcbiAgICAgICAgICAgIGVtcGxveWVlOiB0aGlzLnByb3BzLmVtcGxveWVlXG4gICAgICAgIH07XG4gICAgICAgIHRoaXMub25BbW91bnRDaGFuZ2UgPSB0aGlzLm9uQW1vdW50Q2hhbmdlLmJpbmQodGhpcyk7XG4gICAgICAgIHRoaXMub25TdWJtaXQgPSB0aGlzLm9uU3VibWl0LmJpbmQodGhpcyk7XG4gICAgfVxuXG4gICAgb25BbW91bnRDaGFuZ2UoZXZ0KSB7XG4gICAgICAgIGV2dC5wcmV2ZW50RGVmYXVsdCgpO1xuICAgICAgICBjb25zdCB7dmFsdWV9ID0gZXZ0LnRhcmdldDtcbiAgICAgICAgbGV0IHRtcCA9IHRoaXMuc3RhdGUuZW1wbG95ZWU7XG4gICAgICAgIHRtcC5zYWxhcnkuYW1vdW50ID0gdmFsdWU7XG4gICAgICAgIHRoaXMuc2V0U3RhdGUoe2VtcGxveWVlOiB0bXB9KTtcbiAgICB9XG5cbiAgICBvblN1Ym1pdChldnQpIHtcbiAgICAgICAgZXZ0LnByZXZlbnREZWZhdWx0KCk7XG4gICAgICAgIGNvbnN0IHtlbXBsb3llZX0gPSB0aGlzLnN0YXRlO1xuICAgICAgICB0aGlzLnByb3BzLnVwZGF0ZUVtcGxveWVlKGVtcGxveWVlKTtcbiAgICB9XG5cbiAgICByZW5kZXIoKSB7XG4gICAgICAgIGxldCB7ZW1wbG95ZWV9ID0gdGhpcy5zdGF0ZTtcbiAgICAgICAgcmV0dXJuIChcbiAgICAgICAgICAgIDx0cj5cbiAgICAgICAgICAgICAgICA8dGQ+e2VtcGxveWVlLm5hbWV9PC90ZD5cbiAgICAgICAgICAgICAgICA8dGQ+PGlucHV0IHZhbHVlPXtlbXBsb3llZS5zYWxhcnkuYW1vdW50fSBvbkNoYW5nZT17dGhpcy5vbkFtb3VudENoYW5nZX0vPjwvdGQ+XG4gICAgICAgICAgICAgICAgPHRkPlxuICAgICAgICAgICAgICAgICAgICA8YnV0dG9uIG9uQ2xpY2s9e3RoaXMub25TdWJtaXR9PtCh0L7RhdGA0LDQvdC40YLRjDwvYnV0dG9uPlxuICAgICAgICAgICAgICAgIDwvdGQ+XG4gICAgICAgICAgICA8L3RyPlxuICAgICAgICApXG4gICAgfVxufVxuXG5jb25zdCBtYXBEaXNwYXRjaFRvUHJvcHMgPSBmdW5jdGlvbiAoZGlzcGF0Y2gpIHtcbiAgICByZXR1cm4ge1xuICAgICAgICB1cGRhdGVFbXBsb3llZTogZW1wbG95ZWUgPT4gZGlzcGF0Y2godXBkYXRlRW1wbG95ZWUoZW1wbG95ZWUpKVxuICAgIH1cbn07XG5cbmV4cG9ydCBkZWZhdWx0IGNvbm5lY3QobnVsbCwgbWFwRGlzcGF0Y2hUb1Byb3BzKShFbXBsb3llZVJvdyk7IiwiY29uc3QgYXhpb3MgPSByZXF1aXJlKCdheGlvcycpLmRlZmF1bHQ7XG5cbmNvbnN0IEJBQ0tFTkRfVVJMID0gJ2h0dHA6Ly9sb2NhbGhvc3Q6ODA4MCc7XG5cbmV4cG9ydCBjb25zdCBCQVNFX1VSTCA9IGAke3Byb2Nlc3MuZW52Lk5PREVfRU5WICE9PSBcInByb2R1Y3Rpb25cIiA/IEJBQ0tFTkRfVVJMIDogd2luZG93LmxvY2F0aW9uLm9yaWdpbn1gO1xuZXhwb3J0IGFzeW5jIGZ1bmN0aW9uIGdldEFsbCgpIHtcbiAgICByZXR1cm4gYXhpb3MuZ2V0KEJBU0VfVVJMICsgYC9lbXBsb3llZXNgKS50aGVuKHJlc3AgPT4ge2NvbnNvbGUubG9nKHJlc3AuZGF0YSl9KTtcbn1cblxuIiwiaW1wb3J0IFJlYWN0IGZyb20gJ3JlYWN0JztcbmltcG9ydCB7Y29ubmVjdH0gZnJvbSAncmVhY3QtcmVkdXgnO1xuaW1wb3J0IEVtcGxveWVlIGZyb20gXCIuL0VtcGxveWVlUm93XCI7XG5pbXBvcnQge2dldEFsbH0gZnJvbSBcIi4uL2FwaVwiXG5cbi8qKlxuICog0KLQsNCx0LvQuNGG0LAg0KHQvtGC0YDQutC00L3QuNC60LguXG4gKi9cbmNvbnN0IFRhYmxlSGVhZGVyID0gKCkgPT4ge1xuICAgIHJldHVybiAoXG4gICAgICAgIDx0aGVhZD5cbiAgICAgICAgPHRyPlxuICAgICAgICAgICAgPHRoPtCh0L7RgtGA0YPQtNC90LjQujwvdGg+XG4gICAgICAgICAgICA8dGg+0J7QutC70LDQtDwvdGg+XG4gICAgICAgICAgICA8dGgvPlxuICAgICAgICA8L3RyPlxuICAgICAgICA8L3RoZWFkPlxuICAgIClcbn07XG5cbmNvbnN0IEVtcGxveWVlVGFibGUgPSAocHJvcHMpID0+IHtcbiAgICBsZXQge2VtcGxveWVlc30gPSBwcm9wcztcbiAgICBjb25zb2xlLmxvZyhnZXRBbGwoKSk7XG4gICAgcmV0dXJuIChcbiAgICAgICAgPHRhYmxlPlxuICAgICAgICAgICAgPFRhYmxlSGVhZGVyLz5cbiAgICAgICAgICAgIDx0Ym9keT5cbiAgICAgICAgICAgIHtlbXBsb3llZXMubWFwKChlbXBsb3llZSwgaW5kZXgpID0+IHtcbiAgICAgICAgICAgICAgICByZXR1cm4gKDxFbXBsb3llZSBrZXk9e2luZGV4fSBlbXBsb3llZT17ZW1wbG95ZWV9Lz4pXG4gICAgICAgICAgICB9KX1cbiAgICAgICAgICAgIDwvdGJvZHk+XG4gICAgICAgIDwvdGFibGU+XG4gICAgKVxufTtcblxuY29uc3QgbWFwU3RhdGVUb1Byb3BzID0gZnVuY3Rpb24gKHN0YXRlKSB7XG4gICAgcmV0dXJuIHtcbiAgICAgICAgZW1wbG95ZWVzOiBzdGF0ZS5lbXBsb3llZXNcbiAgICB9XG59O1xuXG5leHBvcnQgZGVmYXVsdCBjb25uZWN0KG1hcFN0YXRlVG9Qcm9wcykoRW1wbG95ZWVUYWJsZSk7XG4iLCJpbXBvcnQgUmVhY3QgZnJvbSAncmVhY3QnO1xuaW1wb3J0IHtjb25uZWN0fSBmcm9tIFwicmVhY3QtcmVkdXhcIjtcbmltcG9ydCB7YWRkRW1wbG95ZWV9IGZyb20gXCIuLi9hY3Rpb25zXCI7XG5cbi8qKlxuICog0JTQvtCx0LDQstC40YLRjCDQodC+0YLRgNGD0LTQvdC40LrQsC5cbiAqL1xuY29uc3QgQWRkRW1wbG95ZWUgPSAoe2Rpc3BhdGNofSkgPT4ge1xuICAgIGxldCBuYW1lSW5wdXQsIGFtb3VudElucHV0O1xuICAgIHJldHVybiAoXG4gICAgICAgIDxkaXY+XG4gICAgICAgICAgICA8Zm9ybSBpZD17J2FkZC1lbXBsb3llZSd9IG9uU3VibWl0PXtldnQgPT4ge1xuICAgICAgICAgICAgICAgIGV2dC5wcmV2ZW50RGVmYXVsdCgpO1xuICAgICAgICAgICAgICAgIGlmICghKCcnICsgbmFtZUlucHV0LnZhbHVlKS50cmltKCkgfHwgISgnJyArIGFtb3VudElucHV0LnZhbHVlKS50cmltKCkpIHtcbiAgICAgICAgICAgICAgICAgICAgcmV0dXJuO1xuICAgICAgICAgICAgICAgIH1cbiAgICAgICAgICAgICAgICBkaXNwYXRjaChhZGRFbXBsb3llZShuYW1lSW5wdXQudmFsdWUsIGFtb3VudElucHV0LnZhbHVlKSk7XG4gICAgICAgICAgICAgICAgbmFtZUlucHV0LnZhbHVlID0gJyc7XG4gICAgICAgICAgICAgICAgYW1vdW50SW5wdXQudmFsdWUgPSAnJztcbiAgICAgICAgICAgIH19PlxuICAgICAgICAgICAgICAgIDxsYWJlbD7QmNC80Y86PC9sYWJlbD5cbiAgICAgICAgICAgICAgICA8aW5wdXQgaWQ9eydhZGQtZW1wbG95ZWUtbmFtZSd9IHJlZj17bm9kZSA9PiB7XG4gICAgICAgICAgICAgICAgICAgIG5hbWVJbnB1dCA9IG5vZGU7XG4gICAgICAgICAgICAgICAgfX0vPlxuICAgICAgICAgICAgICAgIDxsYWJlbD7QntC60LvQsNC0OjwvbGFiZWw+XG4gICAgICAgICAgICAgICAgPGlucHV0IGlkPXsnYWRkLWVtcGxveWVlLWFtb3VudCd9IHJlZj17bm9kZSA9PiB7XG4gICAgICAgICAgICAgICAgICAgIGFtb3VudElucHV0ID0gbm9kZTtcbiAgICAgICAgICAgICAgICB9fS8+XG4gICAgICAgICAgICAgICAgPGJ1dHRvbiBpZD17J2FkZC1lbXBsb3llZS1zdWJtaXQnfSB0eXBlPXtcInN1Ym1pdFwifT7QodC+0LfQtNCw0YLRjDwvYnV0dG9uPlxuICAgICAgICAgICAgPC9mb3JtPlxuICAgICAgICA8L2Rpdj5cbiAgICApXG59O1xuXG5leHBvcnQgZGVmYXVsdCBjb25uZWN0KCkoQWRkRW1wbG95ZWUpO1xuIiwiaW1wb3J0IFJlYWN0IGZyb20gJ3JlYWN0J1xuaW1wb3J0IEVtcGxveWVlTGlzdCBmcm9tIFwiLi9jb21wb25lbnRzL0VtcGxveWVlVGFibGVcIjtcbmltcG9ydCBFbXBsb3llZSBmcm9tIFwiLi9jb21wb25lbnRzL0FkZEVtcGxveWVlXCI7XG5cbmNvbnN0IEFwcCA9ICgpID0+IChcbiAgICA8ZGl2PlxuICAgICAgICA8aDI+Um9zdGVyPC9oMj5cbiAgICAgICAgPEVtcGxveWVlLz5cbiAgICAgICAgPEVtcGxveWVlTGlzdC8+XG4gICAgPC9kaXY+XG4pXG5cbmV4cG9ydCBkZWZhdWx0IEFwcFxuIiwiaW1wb3J0IHtBRERfRU1QTE9ZRUV9IGZyb20gJy4uL2NvbnN0YW50cyc7XG5pbXBvcnQge2NvbWJpbmVSZWR1Y2Vyc30gZnJvbSBcInJlZHV4XCI7XG5cbmNvbnN0IGluaXRpYWxTdGF0ZSA9IFt7aWQ6IDEsIG5hbWU6IFwiYVwiLCBzYWxhcnk6IHtpZDogMSwgY3VycmVuY3k6IFwiUlVSXCIsIGFtb3VudDogXCIxLjIzXCJ9fV07XG5cblxuY29uc3QgZW1wbG95ZWVzID0gKHN0YXRlID0gaW5pdGlhbFN0YXRlLCBhY3Rpb24pID0+IHtcbiAgICBzd2l0Y2ggKGFjdGlvbi50eXBlKSB7XG4gICAgICAgIGNhc2UgQUREX0VNUExPWUVFIDpcbiAgICAgICAgICAgIHJldHVybiBbXG4gICAgICAgICAgICAgICAgLi4uc3RhdGUsXG4gICAgICAgICAgICAgICAge1xuICAgICAgICAgICAgICAgICAgICBpZDogYWN0aW9uLmlkLFxuICAgICAgICAgICAgICAgICAgICBuYW1lOiBhY3Rpb24ubmFtZSxcbiAgICAgICAgICAgICAgICAgICAgc2FsYXJ5OiBhY3Rpb24uc2FsYXJ5LFxuICAgICAgICAgICAgICAgIH1cbiAgICAgICAgICAgIF07XG4gICAgICAgIGRlZmF1bHQ6XG4gICAgICAgICAgICByZXR1cm4gc3RhdGU7XG4gICAgfVxufTtcblxuZXhwb3J0IGRlZmF1bHQgY29tYmluZVJlZHVjZXJzKHtlbXBsb3llZXN9KTtcbiIsImltcG9ydCB7IGFwcGx5TWlkZGxld2FyZSwgY29tYmluZVJlZHVjZXJzLCBjcmVhdGVTdG9yZSB9IGZyb20gJ3JlZHV4JztcbmltcG9ydCB0aHVua01pZGRsZXdhcmUgZnJvbSAncmVkdXgtdGh1bmsnO1xuaW1wb3J0IHsgY29tcG9zZVdpdGhEZXZUb29scyB9IGZyb20gJ3JlZHV4LWRldnRvb2xzLWV4dGVuc2lvbic7XG5pbXBvcnQgcmVkdWNlcnMgZnJvbSBcIi4uL3JlZHVjZXJzXCI7XG5cbmZ1bmN0aW9uIGNvbmZpZ3VyZVN0b3JlKGluaXRpYWxTdGF0ZSkge1xuICAgIHJldHVybiBjcmVhdGVTdG9yZShcbiAgICAgICAgcmVkdWNlcnMsXG4gICAgICAgIGluaXRpYWxTdGF0ZSxcbiAgICAgICAgY29tcG9zZVdpdGhEZXZUb29scyhhcHBseU1pZGRsZXdhcmUoLi4uW3RodW5rTWlkZGxld2FyZV0pKSxcbiAgICApXG59XG5cbmV4cG9ydCBkZWZhdWx0IGNvbmZpZ3VyZVN0b3JlOyIsImltcG9ydCByZWdlbmVyYXRvclJ1bnRpbWUgZnJvbSBcInJlZ2VuZXJhdG9yLXJ1bnRpbWVcIjtcbmltcG9ydCBSZWFjdCBmcm9tICdyZWFjdCc7XG5pbXBvcnQge3JlbmRlcn0gZnJvbSAncmVhY3QtZG9tJztcbmltcG9ydCB7UHJvdmlkZXJ9IGZyb20gJ3JlYWN0LXJlZHV4JztcbmltcG9ydCBBcHAgZnJvbSAnLi9BcHAnO1xuaW1wb3J0IGNvbmZpZ3VyZVN0b3JlIGZyb20gXCIuL3N0b3JlXCI7XG5cbmNvbnN0IHN0b3JlID0gY29uZmlndXJlU3RvcmUoKTtcblxucmVuZGVyKFxuICAgIDxQcm92aWRlciBzdG9yZT17c3RvcmV9PlxuICAgICAgICA8QXBwLz5cbiAgICA8L1Byb3ZpZGVyPixcbiAgICBkb2N1bWVudC5nZXRFbGVtZW50QnlJZCgncm9vdCcpXG4pXG4iXSwibWFwcGluZ3MiOiI7Ozs7Ozs7Ozs7Ozs7Ozs7QUFBQTtBQUNBOztBQ0RBO0FBRUE7QUFDQTtBQUVBO0FBQUE7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUhBO0FBSkE7QUFBQTtBQVdBO0FBQUE7QUFDQTtBQUNBO0FBRkE7QUFBQTs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7QUNoQkE7QUFDQTtBQUNBO0FBRUE7Ozs7QUFHQTs7Ozs7QUFFQTtBQUFBO0FBQ0E7QUFEQTtBQUNBO0FBQUE7QUFDQTtBQUNBO0FBREE7QUFHQTtBQUNBO0FBTkE7QUFPQTtBQUNBOzs7QUFDQTtBQUNBO0FBREE7QUFHQTtBQUNBO0FBQ0E7QUFBQTtBQUFBO0FBQ0E7OztBQUVBO0FBQ0E7QUFEQTtBQUdBO0FBQ0E7OztBQUVBO0FBQUE7QUFFQTtBQUdBO0FBQUE7QUFBQTtBQUVBO0FBQUE7QUFJQTs7OztBQXBDQTtBQUNBO0FBc0NBO0FBQ0E7QUFDQTtBQUFBO0FBQUE7QUFEQTtBQUdBO0FBQ0E7QUFDQTs7Ozs7O0FDcERBO0FBQ0E7QUFDQTtBQUVBO0FBQ0E7QUFBQTtBQUFBO0FBQ0E7Ozs7QUFEQTtBQUFBO0FBQUE7QUFBQTtBQUFBO0FBQUE7QUFDQTtBQUFBO0FBQ0E7QUFGQTtBQUFBO0FBQUE7QUFBQTtBQUFBO0FBQUE7QUFBQTs7OztBQ0xBO0FBQ0E7QUFDQTtBQUNBO0FBRUE7Ozs7QUFHQTtBQUNBO0FBU0E7QUFDQTtBQUNBO0FBQUE7QUFFQTtBQUNBO0FBS0E7QUFBQTtBQUFBO0FBQUE7QUFDQTtBQUlBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFEQTtBQUdBO0FBQ0E7QUFDQTs7QUN6Q0E7QUFDQTtBQUNBO0FBRUE7Ozs7QUFHQTtBQUFBO0FBQ0E7QUFDQTtBQUVBO0FBQUE7QUFDQTtBQUNBO0FBQUE7QUFDQTtBQUNBO0FBQ0E7QUFBQTtBQUNBO0FBQ0E7QUFDQTtBQVJBO0FBVUE7QUFBQTtBQUNBO0FBQ0E7QUFGQTtBQUlBO0FBQUE7QUFDQTtBQUNBO0FBRkE7QUFHQTtBQUFBO0FBQUE7QUFJQTtBQUNBO0FBQ0E7O0FDbENBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFBQTtBQUFBO0FBQ0E7QUFPQTs7Ozs7Ozs7Ozs7Ozs7Ozs7OztBQ1pBO0FBQ0E7QUFFQTtBQUFBO0FBQUE7QUFBQTtBQUFBO0FBQUE7QUFBQTtBQUFBO0FBQUE7QUFDQTtBQUVBO0FBQUE7QUFBQTtBQUNBO0FBQUE7QUFDQTtBQUNBO0FBR0E7QUFDQTtBQUNBO0FBSEE7QUFDQTtBQUtBO0FBQ0E7QUFYQTtBQWFBO0FBQ0E7QUFDQTtBQUFBO0FBQUE7O0FDdEJBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBS0E7QUFDQTtBQUNBOztBQ2JBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUVBO0FBRUE7QUFDQTtBQUFBIiwic291cmNlUm9vdCI6IiJ9\n//# sourceURL=webpack-internal:///50\n')}});