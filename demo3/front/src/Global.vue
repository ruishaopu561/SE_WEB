<script type="text/javascript">

var email = '1747836307@qq.com'
var id = 1
var login = false

function setlogin(newState) {
    this.login = newState
}

function setemail(newEmail) {
    this.email = newEmail
}
function getemail() {
    return this.email
}

function setid (newId) {
    this.id = newId
}
function getid () {
    return this.id
}

export default
{
    id,
    email,
    login,
    setid,
    getid,
    setemail,
    getemail,
    setlogin
}
</script>