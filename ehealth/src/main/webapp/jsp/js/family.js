var people = 
[
	{
		"Id": "5633bdc8-ee28-4cc3-b35b-9c2468b56766",
		"Name": "Mother Person",
		"Gender": "F",
		"XPosition": "1050",
		"YPosition": "400",
		"DistanceToPrimaryLineage": "1"
	},
	{
		"Id": "1b8aae76-f0e2-4454-ae03-2f09495a2962",
		"Name": "Father Person",
		"Gender": "M",
		"XPosition": "350",
		"YPosition": "400",
		"DistanceToPrimaryLineage": "1"
	},
	{
		"Id": "d26c6c0f-6e13-49a1-9e74-d98eb0ee159c",
		"Name": "Maternal Grandfather",
		"Gender": "M",
		"XPosition": "875",
		"YPosition": "300",
		"DistanceToPrimaryLineage": "1"
	},
	{
		"Id": "a807223f-4b8b-4368-a08a-0930e0608f29",
		"Name": "Maternal Grandmother",
		"Gender": "F",
		"XPosition": "1225",
		"YPosition": "300",
		"DistanceToPrimaryLineage": "1"
	},
	{
		"Id": "b88baa8a-efd5-4f7d-9bec-0f3b6d177149",
		"Name": "Paternal Grandmother",
		"Gender": "F",
		"XPosition": "525",
		"YPosition": "300",
		"DistanceToPrimaryLineage": "1"
	},
	{
		"Id": "2bfa4e43-cad3-4a9a-86a0-b942b93faae2",
		"Name": "Paternal Grandfather",
		"Gender": "M",
		"XPosition": "175",
		"YPosition": "300",
		"DistanceToPrimaryLineage": "1"
	},
	{
		"Id": "bb9160c7-7d16-4f7d-97b2-ef57831eb914",
		"Name": "Subject Person",
		"Gender": "F",
		"XPosition": "700",
		"YPosition": "500",
		"DistanceToPrimaryLineage": "1"
	},
	{
		"Id": "5ba31574-060f-4193-940f-db24c3ab1c80",
		"Name": "Sister Person",
		"Gender": "F",
		"XPosition": "525",
		"YPosition": "500",
		"DistanceToPrimaryLineage": "2"
	},
	{
		"Id": "e9ef05bc-67be-4ac2-a566-7138ef9ce42c",
		"Name": "Brother Person",
		"Gender": "M",
		"XPosition": "850",
		"YPosition": "500",
		"DistanceToPrimaryLineage": "2"
	},
	{
		"Id": "b31bf4e4-ff40-44f3-81b2-a2b922b77027",
		"Name": "Mom's Brother",
		"Gender": "M",
		"XPosition": "963",
		"YPosition": "400",
		"DistanceToPrimaryLineage": "2"
	},
	{
		"Id": "397c7581-1747-4d45-80f5-e73f586ea7aa",
		"Name": "Dad's Sister",
		"Gender": "F",
		"XPosition": "438",
		"YPosition": "400",
		"DistanceToPrimaryLineage": "2"
	}
]
var parents = 
[
	{
		"A": "5633bdc8-ee28-4cc3-b35b-9c2468b56766",
		"B": "bb9160c7-7d16-4f7d-97b2-ef57831eb914",
		"Type": "Parent"
	},
	{
		"A": "5633bdc8-ee28-4cc3-b35b-9c2468b56766",
		"B": "5ba31574-060f-4193-940f-db24c3ab1c80",
		"Type": "Parent"
	},
	{
		"A": "5633bdc8-ee28-4cc3-b35b-9c2468b56766",
		"B": "e9ef05bc-67be-4ac2-a566-7138ef9ce42c",
		"Type": "Parent"
	},
	{
		"A": "1b8aae76-f0e2-4454-ae03-2f09495a2962",
		"B": "bb9160c7-7d16-4f7d-97b2-ef57831eb914",
		"Type": "Parent"
	},
	{
		"A": "1b8aae76-f0e2-4454-ae03-2f09495a2962",
		"B": "5ba31574-060f-4193-940f-db24c3ab1c80",
		"Type": "Parent"
	},
	{
		"A": "1b8aae76-f0e2-4454-ae03-2f09495a2962",
		"B": "e9ef05bc-67be-4ac2-a566-7138ef9ce42c",
		"Type": "Parent"
	},
	{
		"A": "d26c6c0f-6e13-49a1-9e74-d98eb0ee159c",
		"B": "5633bdc8-ee28-4cc3-b35b-9c2468b56766",
		"Type": "Parent"
	},
	{
		"A": "d26c6c0f-6e13-49a1-9e74-d98eb0ee159c",
		"B": "b31bf4e4-ff40-44f3-81b2-a2b922b77027",
		"Type": "Parent"
	},
	{
		"A": "a807223f-4b8b-4368-a08a-0930e0608f29",
		"B": "5633bdc8-ee28-4cc3-b35b-9c2468b56766",
		"Type": "Parent"
	},
	{
		"A": "a807223f-4b8b-4368-a08a-0930e0608f29",
		"B": "b31bf4e4-ff40-44f3-81b2-a2b922b77027",
		"Type": "Parent"
	},
	{
		"A": "b88baa8a-efd5-4f7d-9bec-0f3b6d177149",
		"B": "1b8aae76-f0e2-4454-ae03-2f09495a2962",
		"Type": "Parent"
	},
	{
		"A": "b88baa8a-efd5-4f7d-9bec-0f3b6d177149",
		"B": "397c7581-1747-4d45-80f5-e73f586ea7aa",
		"Type": "Parent"
	},
	{
		"A": "2bfa4e43-cad3-4a9a-86a0-b942b93faae2",
		"B": "1b8aae76-f0e2-4454-ae03-2f09495a2962",
		"Type": "Parent"
	},
	{
		"A": "2bfa4e43-cad3-4a9a-86a0-b942b93faae2",
		"B": "397c7581-1747-4d45-80f5-e73f586ea7aa",
		"Type": "Parent"
	}
]
var peers = 
[
	{
		"A": "5633bdc8-ee28-4cc3-b35b-9c2468b56766",
		"B": "1b8aae76-f0e2-4454-ae03-2f09495a2962",
		"Type": "Spouse"
	},
	{
		"A": "d26c6c0f-6e13-49a1-9e74-d98eb0ee159c",
		"B": "a807223f-4b8b-4368-a08a-0930e0608f29",
		"Type": "Spouse"
	},
	{
		"A": "b88baa8a-efd5-4f7d-9bec-0f3b6d177149",
		"B": "2bfa4e43-cad3-4a9a-86a0-b942b93faae2",
		"Type": "Spouse"
	}
]
