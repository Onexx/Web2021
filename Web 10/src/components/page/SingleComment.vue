<template>
    <p>{{comment.id}} : {{comment.text}}</p>
</template>

<script>
export default {
    name: "SingleComment",
    props: ["comment"]
}
</script>

<style scoped>

</style>
