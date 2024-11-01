<h1>[Silver.3] 24479. 깊이 우선 탐색 1</h1>

<a href="https://www.acmicpc.net/problem/24479">👉 문제 보러가기</a>

<h2>성능 요약</h2>
<b>시간 : 968ms, 메모리 : 92292KB</b>

<h2>문제 설명</h2>
<b>오늘도 서준이는 깊이 우선 탐색(DFS) 수업 조교를 하고 있다. 아빠가 수업한 내용을 학생들이 잘 이해했는지 문제를 통해서 확인해보자.

N개의 정점과 M개의 간선으로 구성된 무방향 그래프(undirected graph)가 주어진다. 정점 번호는 1번부터 N번이고 모든 간선의 가중치는 1이다. 정점 R에서 시작하여 깊이 우선 탐색으로 노드를 방문할 경우 노드의 방문 순서를 출력하자.

깊이 우선 탐색 의사 코드는 다음과 같다. 인접 정점은 오름차순으로 방문한다 </b><br>
<table>
    <tr>
        <th style="text-align: left;">dfs(V, E, R) {  # V : 정점 집합, E : 간선 집합, R : 시작 정점 <br>
    visited[R] &lt;- YES;  # 시작 정점 R을 방문 했다고 표시한다.<br>
    for each x ∈ E(R)  # E(R) : 정점 R의 인접 정점 집합.(정점 번호를 오름차순으로 방문한다)<br>
        if (visited[x] = NO) then dfs(V, E, x);
}</th>
    </tr>
</table>

<b>승택이가 위의 규칙을 지키며 강을 건널 때, 밟을 수 있는 징검다리의 최대 수는 몇 개일까?</b><br>

<hr>

<h3>입력</h3>
<b>첫째 줄에 정점의 수 N (5 ≤ N ≤ 100,000), 간선의 수 M (1 ≤ M ≤ 200,000), 시작 정점 R (1 ≤ R ≤ N)이 주어진다.

다음 M개 줄에 간선 정보 u v가 주어지며 정점 u와 정점 v의 가중치 1인 양방향 간선을 나타낸다. (1 ≤ u < v ≤ N, u ≠ v) 모든 간선의 (u, v) 쌍의 값은 서로 다르다.</b>

<hr>

<h3>출력</h3>
<b>첫째 줄부터 N개의 줄에 정수를 한 개씩 출력한다. i번째 줄에는 정점 i의 방문 순서를 출력한다. 시작 정점의 방문 순서는 1이다. 시작 정점에서 방문할 수 없는 경우 0을 출력한다.</b>

<hr>

<h3>입출력 예시 #1</h3>
<table>
    <tr>
        <th>입력</th>
    </tr>
    <tr>
        <td>5 5 1 <br> 1 4 <br> 1 2 <br> 2 3 <br> 2 4 <br> 3 4</td>
    </tr>
</table>

<table>
    <tr>
        <th>츌력</th>
    </tr>
    <tr>
        <td>1 <br> 2 <br> 3 <br> 4 <br> 0</td>
    </tr>
</table>
<b>정점 1번에서 정점 2번을 방문한다. 정점 2번에서 정점 3번을 방문한다. 정점 3번에서 정점 4번을 방문한다. 정점 5번은 정점 1번에서 방문할 수 없다.</b>

<hr>

<a href="https://www.acmicpc.net//">출처 : 백준 코딩 테스트 연습 </a>