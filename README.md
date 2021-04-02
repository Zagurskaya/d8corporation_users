"# online_cash_nzagurskaya"

Login    Password Role           (roleId)
admin    admin    Administrator   (1)
ivanova  ivanova  Kassir          (2)
petrova  petrova  Controller      (3)

Administrator
Users: show, create, update, delete(soft delete)
Reviews: show, delete

Связи:
@ManyToOne(+)
@OneToOne(+)
