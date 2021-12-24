<template>
  <div class="users datatable">
    <div class="caption">User</div>
    <table>
      <thead>
      <tr>
        <th>Id</th>
        <th>Login</th>
        <th>Name</th>
      </tr>
      </thead>
      <tbody>
      <tr v-if="!users" class="noData">
        <td colspan="3">
          No data
        </td>
      </tr>
      <SingleUser  v-for="user in users" :user="user" :key="user.id"></SingleUser>
      </tbody>
    </table>
  </div>
</template>

<script>
import SingleUser from "@/components/main/users/SingleUser";

export default {
  name: "Users",
  props: ["users"],
  components: {
    SingleUser
  }
}
</script>

<style scoped>

</style>
